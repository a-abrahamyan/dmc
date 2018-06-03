package com.lifesoft.dmc

class AnalysedData {

    boolean stemi
    int count

    String male
    String age
    String systolicPressureAverage
    String diastolicPressureAverage
    String heartRateAverage
    String diabetes
    String highLDL
    String highLDLValue
    String arterialHypertension
    String inheritance
    String smoking
    String atrialPermanentRadiance
    String heartMuscleInfarctAnamnesis
    String coronaryInterferenceAnamnesis
    String anamnesisOfCoronaryBypass
    String anamnesisOfPeripheralArterialDisease
    String creatinineAverage
    String creatinine

    String leftCoronaryArtery
    String rightCoronaryArtery
    String frontLandingArtery
    String aorticArch
    String noAccused

    static constraints = {
        stemi(nullable: false)
        male(nullable: false)
        age(nullable: false)
        systolicPressureAverage(nullable: false)
        diastolicPressureAverage(nullable: false)
        heartRateAverage(nullable: false)
        diabetes(nullable: false)
        highLDL(nullable: true)
        highLDLValue(nullable: true)
        arterialHypertension(nullable: false)
        inheritance(nullable: true)
        smoking(nullable: true)
        atrialPermanentRadiance(nullable: false)
        heartMuscleInfarctAnamnesis(nullable: false)
        coronaryInterferenceAnamnesis(nullable: false)
        anamnesisOfCoronaryBypass(nullable: false)
        anamnesisOfPeripheralArterialDisease(nullable: false)
        creatinineAverage(nullable: false)
        creatinine(nullable: false)
        leftCoronaryArtery(nullable: true)
        rightCoronaryArtery(nullable: true)
        frontLandingArtery(nullable: true)
        aorticArch(nullable: true)
        noAccused(nullable: true)

        count(nullable: false)
    }
}
