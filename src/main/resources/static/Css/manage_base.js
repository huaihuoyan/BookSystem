
function checkWindow() {

    console.log(document.body.offsetHeight);//文档高度
    console.log($(window).height());//窗口高度

    if(h > $(window).height()){
        h = (document.body.offsetHeight - 50);
    }

    if(w > ($(window).width() - 50)){
        w = (document.body.offsetWidth - 60);
    }
}

function getTabSelected() {
    var selected = table.checkStatus("table");
    if(selected.data.length < 1){
        layer.msg("请选择");
        return;
    }

    var ids = "";
    if(selected.data.length > 0){
        $.each(selected.data,function (i,val) {
            ids = ids + val.id + ",";
        })
    }
    //去掉最后的逗号
    ids = ids.substr(0,ids.length - 1);
    global_ids = ids;
    global_ids_len = selected.data.length;
}

function delSelected() {
    global_ids = "";
    global_ids_len = 0;
    getTabSelected();
    if(global_ids_len > 0){
        layer.confirm('你是否删除'+global_ids_len+'个吗?', {
            btn:['确定','取消']
        },function () {
           del(global_ids);
        },function () {
            layer.msg("你选择取消");
        })

    }
}