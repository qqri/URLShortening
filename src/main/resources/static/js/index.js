var main = {
    init : function () {
        var _this = this;
        $('#btn-shorten').on('click' , function() {
            _this.shorten();
        });
    },
    shorten : function () {
        var data = {

        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('shortening!!!');
            window.location.href = '/'; // 이거 나중에 여기 바꾸기
        });
    }

};

main.init();