<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>
<a href="#edit-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                             default="Skip to content&hellip;"/></a>

<content tag="nav">
    <ul>
        <li><g:link class="btn btn-primary" action="index"><g:message code="default.list.label"
                                                                      args="[entityName]"/></g:link></li>
        <li><g:link class="btn btn-primary" action="create"><g:message code="default.new.label"
                                                                       args="[entityName]"/></g:link></li>
    </ul>
</content>

<div id="edit-person" class="content scaffold-edit" role="main">
    <h1><g:message code="default.edit.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${this.person}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.person}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:hiddenField name="unCheckedFields" id="unCheckedFields" value="${this.person.uncheckedFields}"/>
    <g:form resource="${this.person}" method="PUT">
        <g:hiddenField name="version" value="${this.person?.version}"/>
        <fieldset class="form">
            <f:all bean="person"
                   order="stemi, male, age, heartRateAverage, diabetes, highLDLValue, arterialHypertension, inheritance, smoking, atrialPermanentRadiance, heartMuscleInfarctAnamnesis, coronaryInterferenceAnamnesis, anamnesisOfCoronaryBypass, anamnesisOfPeripheralArterialDisease, creatinine"/>
            <h4><g:message code="person.gulty.header.label"/></h4>
            <f:all bean="person"
                   order="noAccused, leftCoronaryArtery, rightCoronaryArtery, frontLandingArtery, aorticArch"/>
        </fieldset>
        <fieldset class="buttons">
            <input class="btn btn-success" type="submit"
                   value="${message(code: 'default.button.update.label', default: 'Update')}"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
