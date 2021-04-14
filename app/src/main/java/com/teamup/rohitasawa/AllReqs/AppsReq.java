package com.teamup.rohitasawa.AllReqs;

public class AppsReq {

    String id, packageId, status;


    public AppsReq(String id, String packageId, String status) {
        this.id = id;
        this.packageId = packageId;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}