package com.insurance.main.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;

@Document(collection = "insurance_forms")
public class InsuranceForm {

    @Id
    private String id;

    // Insured's Details
    @NotEmpty(message = "Full Name is required")
    private String fullName;

    @NotEmpty(message = "Address is required")
    private String address;

    @Pattern(regexp = "[0-9]{10}", message = "Mobile Number must be exactly 10 digits")
    private String mobileNumber;

    // Policy Details
    @NotEmpty(message = "Vehicle Number is required")
    private String vehicleNumber;

    @NotEmpty(message = "Vehicle Model Number is required")
    private String vehicleModelNumber;

    @NotEmpty(message = "Vehicle Manufacturer is required")
    private String vehicleManufacturer;

    @NotNull(message = "Year of Manufacture is required")
    private Integer yearOfManufacture;

    @NotEmpty(message = "Vehicle Chassis Number is required")
    private String vehicleChassisNumber;

    @NotEmpty(message = "Fuel Type is required")
    private String fuelType;

    @NotEmpty(message = "Body Type of Vehicle is required")
    private String bodyType;

    @NotNull(message = "Cubic Capacity is required")
    private Integer cubicCapacity;

    @NotEmpty(message = "Colour of Vehicle is required")
    private String vehicleColor;

    @NotEmpty(message = "Policy Receipt Number is required")
    private String policyReceiptNumber;

    // Policy Number (Auto-generated)
    private String policyNumber;

    // Issuing Office Details
    @NotEmpty(message = "Issuing Office Address is required")
    private String issuingOfficeAddress;

    @Pattern(regexp = "[0-9]{10}", message = "Phone Number must be exactly 10 digits")
    private String issuingOfficePhoneNumber;

    @NotEmpty(message = "Issuing Office Fax Number is required")
    private String issuingOfficeFaxNumber;

    @NotEmpty(message = "Issuing Office Email is required")
    private String issuingOfficeEmail;

    // Insurance Premium Details
    @NotNull(message = "Insurance Basic Amount is required")
    private Double insuranceBasicAmount;

    @NotNull(message = "Basic TP Cover Amount is required")
    private Double basicTPCoverAmount;

    @NotNull(message = "TP Premium Amount is required")
    private Double tpPremiumAmount;

    @NotNull(message = "Net Premium is required")
    private Double netPremium;

    @NotNull(message = "Service Tax on Premium is required")
    private Double serviceTaxOnPremium;

    @NotNull(message = "Total Payable is required")
    private Double totalPayable;

    // Constructors, Getters, and Setters

    public InsuranceForm() {
        // Default constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Integer getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Integer yearOfManufacture) {
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

    public Integer getCubicCapacity() {
        return cubicCapacity;
    }

    public void setCubicCapacity(Integer cubicCapacity) {
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

    public Double getInsuranceBasicAmount() {
        return insuranceBasicAmount;
    }

    public void setInsuranceBasicAmount(Double insuranceBasicAmount) {
        this.insuranceBasicAmount = insuranceBasicAmount;
    }

    public Double getBasicTPCoverAmount() {
        return basicTPCoverAmount;
    }

    public void setBasicTPCoverAmount(Double basicTPCoverAmount) {
        this.basicTPCoverAmount = basicTPCoverAmount;
    }

    public Double getTpPremiumAmount() {
        return tpPremiumAmount;
    }

    public void setTpPremiumAmount(Double tpPremiumAmount) {
        this.tpPremiumAmount = tpPremiumAmount;
    }

    public Double getNetPremium() {
        return netPremium;
    }

    public void setNetPremium(Double netPremium) {
        this.netPremium = netPremium;
    }

    public Double getServiceTaxOnPremium() {
        return serviceTaxOnPremium;
    }

    public void setServiceTaxOnPremium(Double serviceTaxOnPremium) {
        this.serviceTaxOnPremium = serviceTaxOnPremium;
    }

    public Double getTotalPayable() {
        return totalPayable;
    }

    public void setTotalPayable(Double totalPayable) {
        this.totalPayable = totalPayable;
    }
}
