package dmc

import com.lifesoft.dmc.AnalysedData
import com.lifesoft.dmc.Person
import com.lifesoft.dmc.TempData
import grails.transaction.Transactional

@Transactional
class DataAnalyserService {

    Map<String, AnalysedData> analyse() {
        Map<String, AnalysedData> dataMap = new HashMap<>()

        dataMap.put("STEMI", analyseSTEMI())
        dataMap.put("NonSTEMI", analyseNonSTEMI())

        return dataMap
    }

    AnalysedData analyseNonSTEMI() {
        List<Person> NonSTEMIPersons = Person.list().findAll { !it.stemi }

        if (NonSTEMIPersons.size() == 0) {
            return new AnalysedData()
        }

        TempData temp = new TempData()
        AnalysedData analysedData = new AnalysedData(stemi: false, count: NonSTEMIPersons.size())

        fillTempData(NonSTEMIPersons, temp)
        fillAnalysedData(analysedData, temp)

        return analysedData
    }

    AnalysedData analyseSTEMI() {
        List<Person> STEMIPersons = Person.list().findAll { it.stemi }

        if (STEMIPersons.size() == 0) {
            return new AnalysedData()
        }

        TempData temp = new TempData()
        AnalysedData analysedData = new AnalysedData(stemi: true, count: STEMIPersons.size())

        fillTempData(STEMIPersons, temp)
        fillAnalysedData(analysedData, temp)

        return analysedData
    }

    private static void fillAnalysedData(AnalysedData analysedData, TempData temp) {
        int allCount = analysedData.count

        analysedData.male = calculatePercent(allCount, temp.male)
        analysedData.diabetes = calculatePercent(allCount, temp.diabetes)
        analysedData.arterialHypertension = calculatePercent(allCount, temp.arterialHypertension)
        analysedData.atrialPermanentRadiance = calculatePercent(allCount, temp.atrialPermanentRadiance)
        analysedData.heartMuscleInfarctAnamnesis = calculatePercent(allCount, temp.heartMuscleInfarctAnamnesis)
        analysedData.coronaryInterferenceAnamnesis = calculatePercent(allCount, temp.coronaryInterferenceAnamnesis)
        analysedData.anamnesisOfCoronaryBypass = calculatePercent(allCount, temp.anamnesisOfCoronaryBypass)
        analysedData.anamnesisOfPeripheralArterialDisease = calculatePercent(allCount, temp.anamnesisOfPeripheralArterialDisease)
        analysedData.creatinine = calculatePercent(allCount, temp.creatinineCount)

//        analysedData.diastolicPressureAverage = calculateAverage(temp.diastolicPressureAverage, allCount)
//        analysedData.systolicPressureAverage = calculateAverage(temp.systolicPressureAverage, allCount)
        analysedData.age = calculateAverage(temp.age, allCount)
        analysedData.heartRateAverage = calculateAverage(temp.heartRateAverage, allCount)
        analysedData.creatinineAverage = calculateAverage(temp.creatinine, allCount)

        analysedData.highLDLValue = calculateDoubleAverage(temp.highLDLValue, temp.highLDLValue_filledCount)

        analysedData.highLDL = calculatePercentForFilled(temp.highLDL_filledCount, temp.highLDL)
        analysedData.inheritance = calculatePercentForFilled(temp.inheritance_filledCount, temp.inheritance)
        analysedData.smoking = calculatePercentForFilled(temp.smoking_filledCount, temp.smoking)

        analysedData.noAccused = calculateFilledCount(temp.noAccused_filledCount)
        analysedData.leftCoronaryArtery = calculateFilledCount(temp.leftCoronaryArtery_filledCount)
        analysedData.rightCoronaryArtery = calculateFilledCount(temp.rightCoronaryArtery_filledCount)
        analysedData.frontLandingArtery = calculateFilledCount(temp.frontLandingArtery_filledCount)
        analysedData.aorticArch = calculateFilledCount(temp.aorticArch_filledCount)
    }

    private static void fillTempData(List<Person> STEMIPersons, TempData temp) {
        STEMIPersons.each { Person person ->
            if (person.highLDLValue) {
                temp.highLDLValue_filledCount++
                temp.highLDLValue += person.highLDLValue
                if (person.highLDLValue >= 1.8) {
                    person.highLDL = true
                }
            }

            //Simple boolean types
            if (person.male) {
                temp.male++
            }
            if (person.diabetes) {
                temp.diabetes++
            }
            if (person.arterialHypertension) {
                temp.arterialHypertension++
            }
            if (person.atrialPermanentRadiance) {
                temp.atrialPermanentRadiance++
            }
            if (person.heartMuscleInfarctAnamnesis) {
                temp.heartMuscleInfarctAnamnesis++
            }
            if (person.coronaryInterferenceAnamnesis) {
                temp.coronaryInterferenceAnamnesis++
            }
            if (person.anamnesisOfCoronaryBypass) {
                temp.anamnesisOfCoronaryBypass++
            }
            if (person.anamnesisOfPeripheralArterialDisease) {
                temp.anamnesisOfPeripheralArterialDisease++
            }

            //Boolean types
            if (person.highLDL != null) {
                temp.highLDL_filledCount++
            }
            if (person.highLDL) {
                temp.highLDL++
            }

            if (person.inheritance != null) {
                temp.inheritance_filledCount++
            }
            if (person.inheritance) {
                temp.inheritance++
            }

            if (person.smoking != null) {
                temp.smoking_filledCount++
            }
            if (person.smoking) {
                temp.smoking++
            }

            if (person.noAccused != null) {
                temp.noAccused_filledCount++
                person.noAccused = true

                person.leftCoronaryArtery = null
                person.rightCoronaryArtery = null
                person.frontLandingArtery = null
                person.aorticArch = null
            }

            if (person.leftCoronaryArtery != null) {
                temp.leftCoronaryArtery_filledCount++
            }

            if (person.rightCoronaryArtery != null) {
                temp.rightCoronaryArtery_filledCount++
            }

            if (person.frontLandingArtery != null) {
                temp.frontLandingArtery_filledCount++
            }

            if (person.aorticArch != null) {
                temp.aorticArch_filledCount++
            }

            if (person.creatinine >= 100) {
                temp.creatinineCount++
            }

            //Integers types
            temp.age += person.age
            temp.heartRateAverage += person.heartRateAverage
            temp.creatinine += person.creatinine
//            temp.systolicPressureAverage += person.systolicPressureAverage
//            temp.diastolicPressureAverage += person.diastolicPressureAverage
        }
    }

    private static String calculateAverage(int value, int count) {
        return (value/count).toString()
    }

    private static String calculateDoubleAverage(Double value, int count) {
        return (value/count).toString()
    }

    private static String calculatePercent(int all, int part) {
        return ((Double)(part/all))*100 + " %"
    }

    private static String calculatePercentForFilled(int all, int part) {
        if (all == 0) {
            return null
        }
        return ((Double)(part/all))*100 + " % " + getFilledCountLabelHtml(all)
    }

    private static String getFilledCountLabelHtml(int allFilled) {
        return "<span class=\"filled-count-holder\">(լրացված է ${allFilled} հատ)</span>"
    }

    private static String calculateFilledCount(int allFilled) {
        return "${allFilled} հատ"
    }
}
