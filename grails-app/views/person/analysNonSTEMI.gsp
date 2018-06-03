<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'nonStemi.header.label')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                             default="Skip to content&hellip;"/></a>

<div id="show-person" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>

    <div class="count-holder">
        <f:display bean="analysedData" order="count"/>
    </div>

    <f:display bean="analysedData" order="male, age, heartRateAverage, diabetes"/>
    <div id="ldl_percent_average" class="percentAverage">
        <f:display bean="analysedData" order="highLDLValue, highLDL"/>
    </div>
    <f:display bean="analysedData"
               order="arterialHypertension, inheritance, smoking, atrialPermanentRadiance, heartMuscleInfarctAnamnesis, coronaryInterferenceAnamnesis, anamnesisOfCoronaryBypass, anamnesisOfPeripheralArterialDisease"/>
    <div id="creatinine_percent_average" class="percentAverage">
        <f:display bean="analysedData" order="creatinineAverage, creatinine"/>
    </div>
    <f:display bean="analysedData"
               order="noAccused, leftCoronaryArtery, rightCoronaryArtery, frontLandingArtery, aorticArch"/>
</div>
</body>
</html>