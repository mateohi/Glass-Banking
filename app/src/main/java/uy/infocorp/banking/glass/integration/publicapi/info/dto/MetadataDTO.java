package uy.infocorp.banking.glass.integration.publicapi.info.dto;

public class MetadataDTO {

    private String[] knownTypes;
    private String fullQualifiedName;
    private String url;

    public String[] getKnownTypes() {
        return knownTypes;
    }

    public void setKnownTypes(String[] knownTypes) {
        this.knownTypes = knownTypes;
    }

    public String getFullQualifiedName() {
        return fullQualifiedName;
    }

    public void setFullQualifiedName(String fullQualifiedName) {
        this.fullQualifiedName = fullQualifiedName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}


