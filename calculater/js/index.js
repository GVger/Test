/**
 * @author Vger
 * 负数进行操作会失败，因为正则表达式会匹配到符号为减号
 */
var currentExp = "";
var show = "0";
var result = null;
var oldSelectBtn = null;/*打算用来动态改变btn的样式，做成选中效果*/

//点击事件绑定
function setClickEvent() {
	$(".btn").each(function() {
		$(this).click(function() {
			var temp = this.getAttribute("value");
			oldSelectBtn = this;
			
			judge(temp);//运算核心
			
			$(".show").html(show);
			console.log(currentExp);
		});
	});
}

//对应按钮value值
function judge(code) {
	switch(code) {
		case "null":
			break;
		case "clear":
			currentExp = "";
			show = "0";
			result = null;
			break;
		case "back":
			if (show.length > 1 && show != "0") {
				currentExp = currentExp.substring(0, currentExp.length - 1);
				show = show.substring(0, show.length - 1);
			} else if (show.length == 1 && show != "0") {//可以说是已经输入了操作符号（有待验证）
				currentExp = currentExp.substring(0, currentExp.length - 1);
				show = "0";
			} else {
			}
			break;
		case "/":
		case "*":
		case "-":
		case "+":
			if(result == null){//如果没有结果的话，则将符号添加到currentExp中
				currentExp = currentExp + code;
			} else {
				currentExp = result + code;
				result = null;
			}
			show = "0";
			break;
		case "=":
			currentExp = currentExp + code;
			decode(currentExp);
			if(result == Infinity){
				show = "除数为零";
				currentExp = "";
			} else {
				show = result;
				currentExp = result;
			}
			break;
		default:
			if(result != null){
				show = show + code;
				currentExp = show;
				result = null;//如果有结果的话，再输入数字的时候则将show和currentExp添加新的数字
			} else {
				//没有结果的时候，先判断第一个是不是0
				if (show == 0) {
					show = code;
				} else {
					show = show + code;
				}
				currentExp = currentExp + code;
			}
			break;
	}
}

//对隐含输入的算术表达式进行解码，接触操作数和操作符号数组
function decode(exp) {
	var reg = /\d+(\.\d+)?([+*/-]\d+(\.\d+)?)+/;
	if (reg.test(exp) != true) {
		show = "0";
		currentExp = "";
		alert("请重新输入表达式");
	} else {
		console.log("输入的表达式正确");
	}
	var num, chr;
	num = currentExp.match(/\d+(\.\d+)?/g);
	chr = currentExp.match(/[^\d\.]/g);
	calculater(num, chr);
	num = null;
	chr = null;
}

//对解码后的操作数和操作符号进行运算操作
function calculater(number, operator) {
	for (var i = 0; i < operator.length; i++) {
		switch(operator[i]) {
		case "+":
		//加号要先转成number型，不然就是字符串变成字符串拼接
			number[i + 1] = eval(number[i]) + eval(number[i + 1]);
			break;
		case "-":
			number[i + 1] = number[i] - number[i + 1];
			break;
		case "*":
			number[i + 1] = number[i] * number[i + 1];
			break;
		case "/":
			number[i + 1] = number[i] / number[i + 1];
			break;
		case "=":
			result = number[number.length - 1];
			break;
		}
	}
}

$(function() {
	setClickEvent();
});
