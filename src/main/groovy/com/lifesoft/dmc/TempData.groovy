package com.lifesoft.dmc

/* Copyrights 2015 FIP Software
 * Date: 2/12/18.
 * Developer: Artak Abrahamyan
 * This software is the proprietary information of FIP Software.
 * Its use is subject to License terms.
 */

class TempData {
    int male
    int diabetes
    int arterialHypertension
    int atrialPermanentRadiance
    int heartMuscleInfarctAnamnesis
    int coronaryInterferenceAnamnesis
    int anamnesisOfCoronaryBypass
    int anamnesisOfPeripheralArterialDisease

    Integer age
    Integer systolicPressureAverage
    Integer diastolicPressureAverage
    Integer heartRateAverage
    Integer creatinine

    Double highLDLValue

    int highLDL
    int inheritance
    int smoking

    int creatinineCount
    int highLDL_filledCount
    int highLDLValue_filledCount
    int inheritance_filledCount
    int smoking_filledCount

    int leftCoronaryArtery_filledCount
    int rightCoronaryArtery_filledCount
    int frontLandingArtery_filledCount
    int aorticArch_filledCount
    int noAccused_filledCount

    TempData() {
        male = 0
        diabetes = 0
        arterialHypertension = 0
        atrialPermanentRadiance = 0
        heartMuscleInfarctAnamnesis = 0
        coronaryInterferenceAnamnesis = 0
        anamnesisOfCoronaryBypass = 0
        anamnesisOfPeripheralArterialDisease = 0

        age = 0
        systolicPressureAverage = 0
        diastolicPressureAverage = 0
        heartRateAverage = 0
        creatinine = 0

        highLDLValue = 0.0

        highLDL = 0
        inheritance = 0
        smoking = 0

        creatinineCount = 0
        highLDL_filledCount = 0
        highLDLValue_filledCount = 0
        inheritance_filledCount = 0
        smoking_filledCount = 0
        leftCoronaryArtery_filledCount = 0
        rightCoronaryArtery_filledCount = 0
        frontLandingArtery_filledCount = 0
        aorticArch_filledCount = 0
        noAccused_filledCount = 0
    }
}
