package uy.infocorp.banking.glass.icbankingglass.service.integration.publicapi.info.dto;

public class ContactItemsGroupsDTO {

    private String id;
    private String creationDate;
    private String order;
    private ItemsDTO[] items;
    private String name;
    private String isDeleted;
    private String modifiedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public ItemsDTO[] getItemsDTO() {
        return items;
    }

    public void setItemsDTO(ItemsDTO[] items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}


