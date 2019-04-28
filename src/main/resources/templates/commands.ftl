<html>

<head>
    <title>Commands</title>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

    <script src="/js/httprequests.js" crossorigin="anonymous"></script>


    <link rel="stylesheet" href="/commands.css" type="text/css">

    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>


</head>

<body>
<#include "./navbar.html" >


<div class="container">

    <div class="row">

        <table class="table">
            <thead>
            <tr>
                <th>Id</th>
                <th>Description</th>
                <th>Value</th>
            </tr>
            </thead>
            <tbody>

            <#list commandsAttribute as command>

                <tr>
                    <td>${command.id}</td>
                    <td>${command.description}</td>
                    <td>${command.value}</td>

                    <td class="run-button">
                        <button class="btn" onclick="postCommand(${command.id})">
                            Run <span class="badge badge-primary"></span>
                        </button>
                    </td>
                </tr>

            </#list>

            </tbody>
        </table>


    </div>

</div>

</body>

</html>
