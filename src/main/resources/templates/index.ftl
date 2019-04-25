<html>
<head>
    <title>Main Dashboard</title>
</head>
<body>


<ul>
    <#list systems as system>
        <li>${system_index + 1}. ${system.name} from ${system.developer}</li>
    </#list>
</ul>

</body>
</html>
