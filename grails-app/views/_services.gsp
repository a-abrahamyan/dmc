<ul class="dropdown-menu">
    <li><g:link controller="person" action="create">
        ${message(code: "default.create.label")}
    </g:link></li>
    <li><g:link controller="person" action="index">
        <i class="icon-search"></i>
        ${message(code: "default.list.label", args: ['Person'])}
    </g:link></li>
</ul>