package uy.infocorp.banking.glass.integration.publicapi.branch;

import android.graphics.Bitmap;
import android.location.Location;
import android.util.Log;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import uy.infocorp.banking.glass.R;
import uy.infocorp.banking.glass.integration.publicapi.image.ImageDownloadClient;
import uy.infocorp.banking.glass.integration.publicapi.info.PublicInfoClient;
import uy.infocorp.banking.glass.integration.publicapi.info.dto.PointsOfInterestDTO;
import uy.infocorp.banking.glass.integration.publicapi.info.dto.PublicInfoDTO;
import uy.infocorp.banking.glass.model.benefit.Branch;
import uy.infocorp.banking.glass.util.math.MathUtils;
import uy.infocorp.banking.glass.util.resources.Resources;

public class BranchClient {

    private static final String TAG = BranchClient.class.getSimpleName();

    private static final String INTEREST_POINT_BRANCH = Resources.getString(R.string.interest_point_branch);
    private static final double MAX_DISTANCE_KM = Resources.getInteger(R.integer.max_distance_branch);
    private static final int MAX_BRANCHES_TO_SHOW = Resources.getInteger(R.integer.max_atms_to_show);

    private static BranchClient instance;

    private BranchClient() {
    }

    public static BranchClient instance() {
        if (instance == null) {
            instance = new BranchClient();
        }
        return instance;
    }

    public List<Branch> getClosestBranches(final Location location) {
        PublicInfoDTO publicInfo = PublicInfoClient.instance().getPublicInfo();

        List<PointsOfInterestDTO> branches = Lists.newArrayList();

        for (PointsOfInterestDTO pointOfInterest : publicInfo.getPointsOfInterestDTO()) {
            String type = pointOfInterest.getType();
            float distanceToAtm = getDistance(location, pointOfInterest.getLatitude(),
                    pointOfInterest.getLongitude());

            if (INTEREST_POINT_BRANCH.equals(type) && MAX_DISTANCE_KM <= distanceToAtm) {
                branches.add(pointOfInterest);
            }
        }

        sortByDistance(location, branches);

        return pointsOfInterestToBranches(branches, location);
    }

    private static List<PointsOfInterestDTO> sortByDistance(final Location location,
                                                            List<PointsOfInterestDTO> branches) {
        Collections.sort(branches, new Comparator<PointsOfInterestDTO>() {
            @Override
            public int compare(PointsOfInterestDTO left, PointsOfInterestDTO right) {
                Float lDistance = getDistance(location, left.getLatitude(), left.getLongitude());
                Float rDistance = getDistance(location, right.getLatitude(), right.getLongitude());

                return lDistance.compareTo(rDistance);
            }
        });

        return branches;
    }

    private static float getDistance(Location location, double latitude, double longitude) {
        double userLatitude = location.getLatitude();
        double userLongitude = location.getLongitude();

        return MathUtils.getDistance(userLatitude, userLongitude, latitude, longitude);
    }

    private static List<Branch> pointsOfInterestToBranches(List<PointsOfInterestDTO> branchesDTO, Location location) {
        List<Branch> branches = Lists.newArrayList();

        for (PointsOfInterestDTO branchDTO : branchesDTO) {
            try {
                String name = branchDTO.getName();
                double latitude = branchDTO.getLatitude();
                double longitude = branchDTO.getLongitude();
                double distance = getDistance(location, latitude, longitude);
                String telephone = branchDTO.getTelephone();
                Bitmap image = ImageDownloadClient.instance().getImage(branchDTO.getImageId());

                Branch branch = new Branch();
                branch.setName(name);
                branch.setLatitude(latitude);
                branch.setLongitude(longitude);
                branch.setDistance(distance);
                branch.setImage(image);
                branch.setTelephone(telephone);

                branches.add(branch);

                if (branches.size() == MAX_BRANCHES_TO_SHOW) {
                    break;
                }
            } catch (Exception e) {
                Log.e(TAG, "No image found for id: " + branchDTO.getImageId());
                // We do not add the branch and go on
            }
        }
        return branches;
    }
}
