<html>
<head>
    <title>Welcome!</title>
    <script src="/webjars/jquery/3.2.1/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('a[name="btnPreview"]').click(function () {
                var popUrl = "/imageView?fileName=" + $(this).data('fileName');
                var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no;";
                window.open(popUrl, "", popOption);
            });
        });
    </script>
</head>
<body>
<form method="post" enctype="multipart/form-data">
    파일 첨부<br>
    <input type="file" name="imgFile">
    <button>전송</button>
    <a href="#" name="btnPreview" data-file-name="${fileName!}">미리보기</a><br>
</form>
</body>
</html>