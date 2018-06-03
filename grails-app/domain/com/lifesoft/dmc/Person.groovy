package com.lifesoft.dmc

class Person {

    boolean stemi = false

    boolean male = false
    Integer age
//    Integer systolicPressureAverage
//    Integer diastolicPressureAverage
    Integer heartRateAverage
    boolean diabetes = false
    Boolean highLDL
    Double highLDLValue
    boolean arterialHypertension = false
    Boolean inheritance
    Boolean smoking
    boolean atrialPermanentRadiance = false
    boolean heartMuscleInfarctAnamnesis = false
    boolean coronaryInterferenceAnamnesis = false
    boolean anamnesisOfCoronaryBypass = false
    boolean anamnesisOfPeripheralArterialDisease = false
    Integer creatinine

    Boolean noAccused
    Boolean leftCoronaryArtery
    Boolean rightCoronaryArtery
    Boolean frontLandingArtery
    Boolean aorticArch

    List<String> uncheckedFields

    static constraints = {
        age(nullable: false)
//        systolicPressureAverage(nullable: false)
//        diastolicPressureAverage(nullable: false)
        heartRateAverage(nullable: false)
        creatinine(nullable: false)

        highLDLValue(nullable: true)
        highLDL(nullable: true)
        inheritance(nullable: true)
        smoking(nullable: true)

        noAccused(nullable: true, validator: {value, object ->
            if (value != null && !value) {
                return ['default.false.message']
            }
        })
        leftCoronaryArtery(nullable: true, validator: {value, object ->
            if (value != null && object.noAccused) {
                return ['default.notCompatible.message']
            } else if (value != null && !value) {
                return ['default.false.message']
            } else {
                return true
            }
        })
        rightCoronaryArtery(nullable: true, validator: {value, object ->
            if (value != null && object.noAccused) {
                return ['default.notCompatible.message']
            } else if (value != null && !value) {
                return ['default.false.message']
            } else {
                return true
            }
        })
        frontLandingArtery(nullable: true, validator: {value, object ->
            if (value != null && object.noAccused) {
                return ['default.notCompatible.message']
            } else if (value != null && !value) {
                return ['default.false.message']
            } else {
                return true
            }
        })
        aorticArch(nullable: true, validator: {value, object ->
            if (value != null && object.noAccused) {
                return ['default.notCompatible.message']
            } else if (value != null && !value) {
                return ['default.false.message']
            } else {
                return true
            }
        })
    }

    static transients = ['uncheckedFields']

    def beforeInsert() {
        if (highLDLValue != null) {
            highLDL = highLDLValue >= 1.8
        } else {
            highLDL = null
        }
    }
}
