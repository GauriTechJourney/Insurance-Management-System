package com.insurance.main.model;

public class Report {
    private String fullName;
    private String address;
    private String mobileNumber;
    private String vehicleNumber;
    private String vehicleModelNumber;
    private String vehicleManufacturer;
    private String yearOfManufacture;
    private String vehicleChassisNumber;
    private String fuelType;
    private String bodyType;
    private String cubicCapacity;
    private String vehicleColor;
    private String policyReceiptNumber;
    private String policyNumber;
    private String issuingOfficeAddress;
    private String issuingOfficePhoneNumber;
    private String issuingOfficeFaxNumber;
    private String issuingOfficeEmail;
    private String insuranceBasicAmount;
    private String basicTPCoverAmount;
    private String tpPremiumAmount;
    private String netPremium;
    private String serviceTaxOnPremium;
    private String totalPayable;
    private String id; // Assuming each report has an ID

    // Default constructor
    public Report() {
    }

    // Parameterized constructor
    public Report(String fullName, String address, String mobileNumber, String vehicleNumber, String vehicleModelNumber, 
                  String vehicleManufacturer, String yearOfManufacture, String vehicleChassisNumber, String fuelType, 
                  String bodyType, String cubicCapacity, String vehicleColor, String policyReceiptNumber, 
                  String policyNumber, String issuingOfficeAddress, String issuingOfficePhoneNumber, 
                  String issuingOfficeFaxNumber, String issuingOfficeEmail, String insuranceBasicAmount, 
                  String basicTPCoverAmount, String tpPremiumAmount, String netPremium, String serviceTaxOnPremium, 
                  String totalPayable, String id) {
        this.fullName = fullName;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.vehicleNumber = vehicleNumber;
        this.vehicleModelNumber = vehicleModelNumber;
        this.vehicleManufacturer = vehicleManufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.vehicleChassisNumber = vehicleChassisNumber;
        this.fuelType = fuelType;
        this.bodyType = bodyType;
        this.cubicCapacity = cubicCapacity;
        this.vehicleColor = vehicleColor;
        this.policyReceiptNumber = policyReceiptNumber;
        this.policyNumber = policyNumber;
        this.issuingOfficeAddress = issuingOfficeAddress;
        this.issuingOfficePhoneNumber = issuingOfficePhoneNumber;
        this.issuingOfficeFaxNumber = issuingOfficeFaxNumber;
        this.issuingOfficeEmail = issuingOfficeEmail;
        this.insuranceBasicAmount = insuranceBasicAmount;
        this.basicTPCoverAmount = basicTPCoverAmount;
        this.tpPremiumAmount = tpPremiumAmount;
        this.netPremium = netPremium;
        this.serviceTaxOnPremium = serviceTaxOnPremium;
        this.totalPayable = totalPayable;
        this.id = id;
    }

    // Getters and Setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleModelNumber() {
        return vehicleModelNumber;
    }

    public void setVehicleModelNumber(String vehicleModelNumber) {
        this.vehicleModelNumber = vehicleModelNumber;
    }

    public String getVehicleManufacturer() {
        return vehicleManufacturer;
    }

    public void setVehicleManufacturer(String vehicleManufacturer) {
        this.vehicleManufacturer = vehicleManufacturer;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getVehicleChassisNumber() {
        return vehicleChassisNumber;
    }

    public void setVehicleChassisNumber(String vehicleChassisNumber) {
        this.vehicleChassisNumber = vehicleChassisNumber;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getCubicCapacity() {
        return cubicCapacity;
    }

    public void setCubicCapacity(String cubicCapacity) {
        this.cubicCapacity = cubicCapacity;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getPolicyReceiptNumber() {
        return policyReceiptNumber;
    }

    public void setPolicyReceiptNumber(String policyReceiptNumber) {
        this.policyReceiptNumber = policyReceiptNumber;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getIssuingOfficeAddress() {
        return issuingOfficeAddress;
    }

    public void setIssuingOfficeAddress(String issuingOfficeAddress) {
        this.issuingOfficeAddress = issuingOfficeAddress;
    }

    public String getIssuingOfficePhoneNumber() {
        return issuingOfficePhoneNumber;
    }

    public void setIssuingOfficePhoneNumber(String issuingOfficePhoneNumber) {
        this.issuingOfficePhoneNumber = issuingOfficePhoneNumber;
    }

    public String getIssuingOfficeFaxNumber() {
        return issuingOfficeFaxNumber;
    }

    public void setIssuingOfficeFaxNumber(String issuingOfficeFaxNumber) {
        this.issuingOfficeFaxNumber = issuingOfficeFaxNumber;
    }

    public String getIssuingOfficeEmail() {
        return issuingOfficeEmail;
    }

    public void setIssuingOfficeEmail(String issuingOfficeEmail) {
        this.issuingOfficeEmail = issuingOfficeEmail;
    }

    public String getInsuranceBasicAmount() {
        return insuranceBasicAmount;
    }

    public void setInsuranceBasicAmount(String insuranceBasicAmount) {
        this.insuranceBasicAmount = insuranceBasicAmount;
    }

    public String getBasicTPCoverAmount() {
        return basicTPCoverAmount;
    }

    public void setBasicTPCoverAmount(String basicTPCoverAmount) {
        this.basicTPCoverAmount = basicTPCoverAmount;
    }

    public String getTpPremiumAmount() {
        return tpPremiumAmount;
    }

    public void setTpPremiumAmount(String tpPremiumAmount) {
        this.tpPremiumAmount = tpPremiumAmount;
    }

    public String getNetPremium() {
        return netPremium;
    }

    public void setNetPremium(String netPremium) {
        this.netPremium = netPremium;
    }

    public String getServiceTaxOnPremium() {
        return serviceTaxOnPremium;
    }

    public void setServiceTaxOnPremium(String serviceTaxOnPremium) {
        this.serviceTaxOnPremium = serviceTaxOnPremium;
    }

    public String getTotalPayable() {
        return totalPayable;
    }

    public void setTotalPayable(String totalPayable) {
        this.totalPayable = totalPayable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}