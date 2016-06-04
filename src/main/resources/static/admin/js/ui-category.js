var level = 1;

var CategoryData = {
    parent: '',
    id : '',
    name : '',
}

var addBeforeCategory = function () {

    if(level == 3) {
        UIToastr.showToastr('하위 카테고리를 더이상 추가할 수 없습니다');
    } else {

        $("#savebtn").show()
        $("#editbtn, #deletebtn").hide();
        $("#savedom").show();

        if(CategoryData.id == '' || CategoryData.id == 'all-category') {
            CategoryData.parent = 'top';
            CategoryData.depth  = 1;
        } else {
            CategoryData.parent = CategoryData.id;
        }

        $("#category-name").val('');

    }

}

var saveCategory = function () {
    if( ($("#category-name").val()) == '') {
        UIToastr.showToastr('생성하실 카테고리명을 입력하세요');
    } else {

        CategoryData.name = $("#category-name").val();
        $.post('/api/admin/categorys', CategoryData, function (response) {
            console.log(response);
            if(response == undefined || response == null) {
                UIToastr.showToastr('카테고리 생성에 실패하였습니다\n잠시 후 다시 시도해주세요');
            } else {
                window.location.reload(true);
            }
        });
    }
}

var deleteCategory = function () {
    if(CategoryData.id == '' || CategoryData.id == 'all-category') {
        UIToastr.showToastr('삭제하실 카테고리를 선택하세요');
    } else {
        $.post('/api/admin/categorys/delete', CategoryData, function (response) {
            if(response == CategoryData.id) {
                window.location.reload(true);
            } else {
                UIToastr.showToastr('카테고리 삭제에 실패하였습니다\n잠시 후 다시 시도해주세요');
            }
        });
    }
}

var editCategory = function () {
    if(CategoryData.id == '' || CategoryData.id == 'all-category') {
        UIToastr.showToastr('수정하실 카테고리를 선택하세요');
    } else if($("#category-name").val().trim() == '') {
        UIToastr.showToastr('수정하실 카테고리명을 입력하세요');
    } else {

        CategoryData.name = $("#category-name").val();
        $.post('/api/admin/categorys/edit', CategoryData, function (response) {
            if(response.id == CategoryData.id) {
                window.location.reload(true);
            } else {
                UIToastr.showToastr('카테고리 수정에 실패하였습니다\n잠시 후 다시 시도해주세요');
            }
        });
    }
}

$(function () {

    var categorytree= $('#categorytree').jstree({
        'plugins': ["types"]
    });

    $("#categorytree").bind('select_node.jstree', function (e, data) {

        $("#selected-name").text(data.node.text);

        CategoryData.id = data.node.id;

        if(data.node.id == 'all-category') {

            CategoryData.name = '';

            $("#category-name").val('');

            $("#savebtn, #editbtn, #deletebtn").hide();

            $("#savedom").hide();

        } else {

            CategoryData.name = data.node.text;

            $("#category-name").val(data.node.text);

            $("#savebtn").hide();

            $("#editbtn, #deletebtn").show();

            $("#savedom").show();

        }

        level = data.node.parents.length;


    });


});