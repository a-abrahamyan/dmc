package dmc

import com.lifesoft.dmc.Person
import grails.transaction.Transactional
import grails.web.servlet.mvc.GrailsParameterMap

@Transactional(readOnly = true)
class DmcService {

    static void getUncheckedFields(Person person) {
        List<String> uncheckedProperties = []

        Person.gormPersistentEntity.persistentPropertyNames.each { String propName ->
            if (person."${propName}" == null && !(propName in ["version", "highLDL"])) {
                uncheckedProperties.add(propName)
            }
        }

        person.uncheckedFields = uncheckedProperties
    }

    static void updateBooleanFields(Person person, GrailsParameterMap params) {
        if (!params.containsKey('highLDLValue')) {
            person.highLDLValue = null
        }

        if (!params.containsKey('inheritance')) {
            person.inheritance = null
        }

        if (!params.containsKey('smoking')) {
            person.smoking = null
        }

        if (!params.containsKey('noAccused')) {
            person.noAccused = null
        }

        if (!params.containsKey('leftCoronaryArtery')) {
            person.leftCoronaryArtery = null
        }

        if (!params.containsKey('rightCoronaryArtery')) {
            person.rightCoronaryArtery = null
        }

        if (!params.containsKey('frontLandingArtery')) {
            person.frontLandingArtery = null
        }

        if (!params.containsKey('aorticArch')) {
            person.aorticArch = null
        }
    }
}
