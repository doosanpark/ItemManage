$(document).ready(function(){

	setGridItemAcqird();	//취득물건
	setGridItemPossess();	//보유물건
	setGridItemInfo();		//물건정보

})


//물건 정렬 버튼	
$("#orgnizItemData").click(function() {
	
    $.ajax({
        type : "POST"
        , data: {"order": "true"}
        , url : "/orgnizItemData.do"      
        , success : function(res){
	
			if(res == 0){
				alert("변경된 정보가 없습니다.");
			} else if(res == 1){
	            location.reload();
			}
	
        }
    });
	
})

//물건 등록 버튼	
$("#btnRegItem").click(function() {
	
	var itemName = $("#itemName").val();
	var itemYear = $("#itemYear").val();
	var itemMonth = $("#itemMonth").val();
	
	if(itemName == ""){
		alert("물건명을 입력해야합니다.");
		return;
	}
	if(itemYear == "" && itemMonth == ""){
		alert("내구연한을 입력해야합니다.");
		return;
	}
	
    $.ajax({
        type : "POST"
        , data: {
			"itemName": itemName
			, "itemMonth": (parseInt(itemYear*12) + parseInt(itemMonth))
		}
        , url : "/regItem.do"      
        , success : function(res){
	
			if(res == 0){
				alert("변경된 정보가 없습니다.");
			} else if(res == 1){
				alert("등록되었습니다.");
	            location.reload();
			}
	
        }
    });
	
})


//취득물건	
function setGridItemAcqird(){
    $.ajax({
        type : "POST",
        data: {"order": "false"},
        url : "/itemAcqird.do",
        success : function(res){
            $("#itemInfoInOracle").jqGrid({
		        colModel: [
		        	{ name: "ITM_NM", label: "물건명", align: "center"}
		           ,{ name: "ITM_CNT", label: "물건 개수", align: "center", width: 60  }
		           ,{ name: "ACQIRD_DATE", label: "취득일자", align: "center" }
		        ],
		        data: res
		    });
        }
    });
}


//보유물건	
function setGridItemPossess(){
    $.ajax({
        type : "POST",
        data: {"order": "false"},
        url : "/itemPossess.do",
        success : function(res){
            $("#itemPosesses").jqGrid({
		        colModel: [
		        	{ name: "ITM_EACH_SEQ", label: "고유번호", align: "center", width: 60 }
		           ,{ name: "ITM_NM", label: "물건명", align: "center" }
		           ,{ name: "ACQIRD_DATE", label: "취득일자", align: "center" }
		           ,{ name: "DUE_DATE", label: "내구기한", align: "center"}
		        ],
		        data: res
		    });
        }
    });
}


//물건정보	
function setGridItemInfo(){
    $.ajax({
        type : "POST",        
        url : "/itemInfo.do",      
        success : function(res){
            $("#itemInfo").jqGrid({
		        colModel: [
		        	{ name: "ITM_NM", label: "물건명", align: "center" }
		           ,{ name: "DURABLE_DATE", label: "내구연한", align: "center", width: 60 }
		        ],
		        data: res
		    });
        }
    });
}