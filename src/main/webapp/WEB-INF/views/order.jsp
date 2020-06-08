<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
    <title>Insert title here</title>
    <style>
        input {
            width: 300px;
            height: 20px;
            border: 1px solid gray
        }
    </style>
    <!-- jquery 는 가맹점에서 이용중인 jquery 버전으로 이용하셔도 됩니다. -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://testcpay.payple.kr/js/cpay.payple.1.0.0.js"></script> <!-- TEST -->
</head>

<script>
    $(document).ready(function () {
        $('#orderFormSubmit').on('click', function (event) {
            var fm = $('#orderForm')[0];
            fm.method = 'POST';
            fm.action = 'order_confirm';
            fm.submit();
            event.preventDefault();
        });
    });
</script>

<body>
    <form id="orderForm" name="orderForm">
        <input type="hidden" name="buyer_no" id="buyer_no" value="2335">
        <div>
            <label for="buyer_name">구매자 이름</label>
            <input type="text" name="buyer_name" id="buyer_name" value="홍길동">
        </div>
        <div>
            <label for="buyer_hp">구매자 휴대폰번호</label>
            <input type="text" name="buyer_hp" id="buyer_hp" value="01012345678">
        </div>
        <div>
            <label for="buyer_email">구매자 Email</label>
            <input type="text" name="buyer_email" id="buyer_email" value="test@payple.co.kr">
        </div>
        <div>
            <label for="buy_goods">구매상품</label>
            <input type="text" name="buy_goods" id="buy_goods" value="휴대폰">
        </div>
        <div>
            <label for="buy_total">결제금액</label>
            <input type="text" name="buy_total" id="buy_total" value="1000">
        </div>
        <div>
            <label for="order_num">주문번호</label>
            <input type="text" name="order_num" id="order_num" value="test0376041001583826312">
        </div>
        <div>
            <label for="is_reguler">정기결제</label>
            <select id="is_reguler" name="is_reguler">
                <option value="N">N</option>
                <option value="Y">Y</option>
            </select>
        </div>
        <div>
            <label for="pay_year">정기결제 구분년도</label>
            <select id="pay_year" name="pay_year">
                <option value="">===</option>
                <option value="2018">2018</option>
                <option value="2017">2017</option>
            </select>
        </div>
        <div>
            <label for="pay_month">정기결제 구분월</label>
            <select id="pay_month" name="pay_month">
                <option value="">===</option>
                <option value="12">12</option>
                <option value="11">11</option>
                <option value="10">10</option>
                <option value="9">9</option>
                <option value="8">8</option>
                <option value="7">7</option>
                <option value="6">6</option>
                <option value="5">5</option>
                <option value="4">4</option>
                <option value="3">3</option>
                <option value="2">2</option>
                <option value="1">1</option>
            </select>
        </div>
        <div>
            <label for="is_taxsave">현금영수증</label>
            <select id="is_taxsave" name="is_taxsave">
                <option value="N">N</option>
                <option value="Y">Y</option>
            </select>
        </div>
        <div>
            <label for="work_type">결제요청방식</label>
            <select id="work_type" name="work_type">
                <option value="CERT">결제요청->결제확인->결제완료</option>
                <option value="PAY">결제요청->결제완료</option>
            </select>
        </div>
    </form>
    <button id="orderFormSubmit">상품구매</button>
</body>

</html>