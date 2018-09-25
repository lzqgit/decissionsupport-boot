package com.phy.decisionsupport.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:outsideInterface.properties")
public class OutsideInterface {
    @Value("${emergencyExpertgetOutDataURL}")
    private String emergencyExpertgetOutDataURL;

    @Value("${emergencySupplygetOutDataURL}")
    private String emergencySupplygetOutDataURL;

    @Value("${FireFightingForcegetOutDataURL}")
    private String FireFightingForcegetOutDataURL;

    @Value("${MedicalInstitutiongetOutDataURL}")
    private String MedicalInstitutiongetOutDataURL;

    @Value("${PublicSecurityForcegetOutDataURL}")
    private String PublicSecurityForcegetOutDataURL;

    @Value("${RefugegetOutDataURL}")
    private String RefugegetOutDataURL;

    @Value("${RescueCounterplangetOutDataURL}")
    private String RescueCounterplangetOutDataURL;

    @Value("${TransportationPowergetOutDataURL}")
    private String TransportationPowergetOutDataURL;

    @Value("${OrderInfoOutDataURL}")
    private String OrderInfoOutDataURL;

    @Value("${HistoricalAccidentgetOutDataURL}")
    private String HistoricalAccidentgetOutDataURL;

    @Value("${vehicleTypegetOutDataURL}")
    private String vehicleTypegetOutDataURL;

    @Value("${vehicleViolationgetOutDataURL}")
    private String vehicleViolationgetOutDataURL;

    @Value("${publicComplainStatisticsgetOutDataURL}")
    private String publicComplainStatisticsgetOutDataURL;

    @Value("${publicComplaingetOutDataURL}")
    private String publicComplaingetOutDataURL;

    @Value("${eispComplainStatisticsgetOutDataURL}")
    private String eispComplainStatisticsgetOutDataURL;

    @Value("${eispComplaingetOutDataURL}")
    private String eispComplaingetOutDataURL;


    public String getEmergencyExpertgetOutDataURL() {
        return emergencyExpertgetOutDataURL;
    }

    public void setEmergencyExpertgetOutDataURL(String emergencyExpertgetOutDataURL) {
        this.emergencyExpertgetOutDataURL = emergencyExpertgetOutDataURL;
    }

    public String getEmergencySupplygetOutDataURL() {
        return emergencySupplygetOutDataURL;
    }

    public void setEmergencySupplygetOutDataURL(String emergencySupplygetOutDataURL) {
        this.emergencySupplygetOutDataURL = emergencySupplygetOutDataURL;
    }

    public String getFireFightingForcegetOutDataURL() {
        return FireFightingForcegetOutDataURL;
    }

    public void setFireFightingForcegetOutDataURL(String fireFightingForcegetOutDataURL) {
        FireFightingForcegetOutDataURL = fireFightingForcegetOutDataURL;
    }

    public String getMedicalInstitutiongetOutDataURL() {
        return MedicalInstitutiongetOutDataURL;
    }

    public void setMedicalInstitutiongetOutDataURL(String medicalInstitutiongetOutDataURL) {
        MedicalInstitutiongetOutDataURL = medicalInstitutiongetOutDataURL;
    }

    public String getPublicSecurityForcegetOutDataURL() {
        return PublicSecurityForcegetOutDataURL;
    }

    public void setPublicSecurityForcegetOutDataURL(String publicSecurityForcegetOutDataURL) {
        PublicSecurityForcegetOutDataURL = publicSecurityForcegetOutDataURL;
    }

    public String getRefugegetOutDataURL() {
        return RefugegetOutDataURL;
    }

    public void setRefugegetOutDataURL(String refugegetOutDataURL) {
        RefugegetOutDataURL = refugegetOutDataURL;
    }

    public String getRescueCounterplangetOutDataURL() {
        return RescueCounterplangetOutDataURL;
    }

    public void setRescueCounterplangetOutDataURL(String rescueCounterplangetOutDataURL) {
        RescueCounterplangetOutDataURL = rescueCounterplangetOutDataURL;
    }

    public String getTransportationPowergetOutDataURL() {
        return TransportationPowergetOutDataURL;
    }

    public void setTransportationPowergetOutDataURL(String transportationPowergetOutDataURL) {
        TransportationPowergetOutDataURL = transportationPowergetOutDataURL;
    }

    public String getOrderInfoOutDataURL() {
        return OrderInfoOutDataURL;
    }

    public void setOrderInfoOutDataURL(String orderInfoOutDataURL) {
        OrderInfoOutDataURL = orderInfoOutDataURL;
    }

    public String getHistoricalAccidentgetOutDataURL() {
        return HistoricalAccidentgetOutDataURL;
    }

    public void setHistoricalAccidentgetOutDataURL(String historicalAccidentgetOutDataURL) {
        HistoricalAccidentgetOutDataURL = historicalAccidentgetOutDataURL;
    }

    public String getVehicleTypegetOutDataURL() {
        return vehicleTypegetOutDataURL;
    }

    public void setVehicleTypegetOutDataURL(String vehicleTypegetOutDataURL) {
        this.vehicleTypegetOutDataURL = vehicleTypegetOutDataURL;
    }

    public String getVehicleViolationgetOutDataURL() {
        return vehicleViolationgetOutDataURL;
    }

    public void setVehicleViolationgetOutDataURL(String vehicleViolationgetOutDataURL) {
        this.vehicleViolationgetOutDataURL = vehicleViolationgetOutDataURL;
    }

    public String getPublicComplainStatisticsgetOutDataURL() {
        return publicComplainStatisticsgetOutDataURL;
    }

    public void setPublicComplainStatisticsgetOutDataURL(String publicComplainStatisticsgetOutDataURL) {
        this.publicComplainStatisticsgetOutDataURL = publicComplainStatisticsgetOutDataURL;
    }

    public String getPublicComplaingetOutDataURL() {
        return publicComplaingetOutDataURL;
    }

    public void setPublicComplaingetOutDataURL(String publicComplaingetOutDataURL) {
        this.publicComplaingetOutDataURL = publicComplaingetOutDataURL;
    }

    public String getEispComplainStatisticsgetOutDataURL() {
        return eispComplainStatisticsgetOutDataURL;
    }

    public void setEispComplainStatisticsgetOutDataURL(String eispComplainStatisticsgetOutDataURL) {
        this.eispComplainStatisticsgetOutDataURL = eispComplainStatisticsgetOutDataURL;
    }

    public String getEispComplaingetOutDataURL() {
        return eispComplaingetOutDataURL;
    }

    public void setEispComplaingetOutDataURL(String eispComplaingetOutDataURL) {
        this.eispComplaingetOutDataURL = eispComplaingetOutDataURL;
    }
}
