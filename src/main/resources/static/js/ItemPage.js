$(document).ready(function(){
	
	 // ajax 통신
    $.ajax({
        type : "POST",            // HTTP method type(GET, POST) 형식이다.
        url : "/basicInfo",      // 컨트롤러에서 대기중인 URL 주소이다.
        data : {"data": "data"},            // Json 형식의 데이터이다.
        success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
        
            // 응답코드 > 0000
            $("#itemInfoInMySql").jqGrid({
		        colModel: [
		        	{ name: "ITM_SEQ" }
		           ,{ name: "ITM_NM" }
		           ,{ name: "ITM_CNT" }
		           ,{ name: "ACQIRD_DATE" }
		        ],
		        data: res
		    });
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
            //alert("통신 실패.")
        }
    });
	
	
	$(function () {
	    
	     $("#itemInfoInOracle").jqGrid({
	        colModel: [
	            { name: "itm_seq" }
	           ,{ name: "itm_nm" }
	           ,{ name: "itm_cnt" }
	           ,{ name: "acqird_date" }
	        ],
	        data: [
	            { itm_seq: 10, itm_nm: "a", itm_cnt: 1, acqird_date: "Merkel" }
	            , { itm_seq: 20, itm_nm: "b", itm_cnt: 2, acqird_date: "Merkel" }
	            , { itm_seq: 30, itm_nm: "c", itm_cnt: 3, acqird_date: "Merkel" }
	            , { itm_seq: 40, itm_nm: "d", itm_cnt: 4, acqird_date: "Merkel" }
	           
	        ]
	    });
	    
	    $("#itemPosesses").jqGrid({
	        colModel: [
	            { name: "itm_seq" }
	           ,{ name: "itm_nm" }
	           ,{ name: "itm_cnt" }
	           ,{ name: "acqird_date" }
	        ],
	        data: [
	            { itm_seq: 10, itm_nm: "a", itm_cnt: 1, acqird_date: "Merkel" }
	            , { itm_seq: 20, itm_nm: "b", itm_cnt: 2, acqird_date: "Merkel" }
	            , { itm_seq: 30, itm_nm: "c", itm_cnt: 3, acqird_date: "Merkel" }
	            , { itm_seq: 40, itm_nm: "d", itm_cnt: 4, acqird_date: "Merkel" }
	           
	        ]
	    });
	    
	    $("#itemInfo").jqGrid({
	        colModel: [
	            { name: "itm_seq" }
	           ,{ name: "itm_nm" }
	           ,{ name: "itm_cnt" }
	           ,{ name: "acqird_date" }
	        ],
	        data: [
	            { itm_seq: 10, itm_nm: "a", itm_cnt: 1, acqird_date: "Merkel" }
	            , { itm_seq: 20, itm_nm: "b", itm_cnt: 2, acqird_date: "Merkel" }
	            , { itm_seq: 30, itm_nm: "c", itm_cnt: 3, acqird_date: "Merkel" }
	            , { itm_seq: 40, itm_nm: "d", itm_cnt: 4, acqird_date: "Merkel" }
	           
	        ]
	    });
	});
	
	
})