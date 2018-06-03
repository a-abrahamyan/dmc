<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                             default="Skip to content&hellip;"/></a>

<content tag="nav">
    <ul>
        <li><g:link class="btn btn-primary" action="create"><g:message code="default.new.label"
                                                                       args="[entityName]"/></g:link></li>
    </ul>
</content>

<div id="list-person" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>

    <g:if test="${personCount && personCount > 0}">
        <f:table collection="${personList}" properties="['id', 'stemi', 'male', 'age', 'diabetes', 'creatinine']"/>
    </g:if>
    <g:else>
        <div class="message" role="status">Person list is empty</div>
    </g:else>

    <g:if test="${personCount && personCount > 10}">
        <div class="pagination">
            <g:paginate total="${personCount ?: 0}"/>
        </div>
    </g:if>


</div>
</body>
</html>