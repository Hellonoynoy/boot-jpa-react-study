var UIToastr = function () {

    return {
        //main function to initiate the module
        init: function () {

            toastr.options = {
                "closeButton": true,
                "debug": false,
                "positionClass": "toast-bottom-center",
                "showDuration": "1000",
                "hideDuration": "1000",
                "timeOut": "5000",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
            }

            $('#cleartoasts').click(function () {
                toastr.clear();
            });

        },
        showToastr : function (msg) {
            var msg     = msg;
            var title   = 'message';
            toastr['success'](msg, title);
        }

    };

}();