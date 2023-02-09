
let AliceJ = {
    ajax : function (param){
        fetch(param.url, {
            method: param.type, // or 'PUT'
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(param.data),
        })
            .then(response => response.json())
            .then(data => {
                // 处理404
                if(data.status === 404){
                    console.log(data.path+"接口404");
                }else{
                    // 处理业务异常
                    if(data.success === false){
                        console.log("异常编号：" + data.errorCode + "，" + data.errorMessage);
                    }else{
                        param.success(data);
                    }
                }

            })
            .catch((error) => {
                console.error('Error:', error);
                param.error(error);
            });
    }
}