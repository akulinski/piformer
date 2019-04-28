function postCommand(id) {

    const executeCommandurl = "/api/execute-command/" + id;

    axios.get(executeCommandurl)
        .then(function (response) {
            console.log(response);
        });

}
