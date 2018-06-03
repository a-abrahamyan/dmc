<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                             default="Skip to content&hellip;"/></a>

<content tag="nav">
    <ul>
        <li><g:link class="btn btn-primary" action="index"><g:message code="default.list.label"
                                                                      args="[entityName]"/></g:link></li>
        <li><g:link class="btn btn-primary" action="create"><g:message code="default.new.label"
                                                                       args="[entityName]"/></g:link></li>
    </ul>
</content>

<div id="show-person" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <f:display bean="person" order="stemi, male, age, heartRateAverage, diabetes, highLDLValue, highLDL, arterialHypertension, inheritance, smoking, atrialPermanentRadiance, heartMuscleInfarctAnamnesis, coronaryInterferenceAnamnesis, anamnesisOfCoronaryBypass, anamnesisOfPeripheralArterialDisease, creatinine, noAccused, leftCoronaryArtery, rightCoronaryArtery, frontLandingArtery, aorticArch"/>
    <g:form resource="${this.person}" method="DELETE">
        <fieldset class="buttons">
            <g:link class="btn btn-info" style="text-decoration:none;" action="edit" resource="${this.person}">
                <g:message code="default.button.edit.label" default="Edit"/>
            </g:link>
            <input class="btn btn-danger" type="submit"
                   value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                   onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
