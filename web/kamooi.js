/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var canvas;
var ctx;
var tintcanvas;
var ttx;
var hexChart = {};
var currentFilter = "overlay";
var isFirefox = typeof InstallTrigger !== 'undefined';  


var currentKamooi = 0; //0 = femuireg 1 = femuibig 2 = mamuireg 3 = mamuibig
var currentHair = 1;
var currentFace = 0;
var currentClip = 0;
var currentFeature = 0;
var currentColor = 3;

var colorList = ["#F1EFE6","#C35654","#D1876A","#E9D7C1","#A6D1A2","#7AB6C0","#90A6CF","#C9A0D1","#F9D7DB","#C1A798","#9FA0A1","#9B3F42","#996049","#CABFA2","#698059","#377781","#4A5877","#81608A","#EAAFB2","#817062","#5A5850","#E75860","#F1976E","#E9D699","#89CE84","#7FE0DB","#4881B3","#AB7ED3","#F28FA9","#69473D"]; 
	//			["#D7BFBB","#AD4840","#B96850","#ceae9d","#8EA57C","#669897","#8188A6","#B383A9","#DEADAF","#AA867C","#907C82","#8B3035","#815039","#B09884","#616844","#377881","#41485F","#734F6F","#CD8588","#6F554F","#4C4041","#CB4856","#D8795D","#C9AF77","#76A56A","#74AFB1","#3E6A8D","#9966A9","#D17786","#604133"];
	//			["#f8ebd4","#c84743","#d67854","#f7d3ae","#c0dd9d","#8fcac5","#b1c7e7","#e1aee4","#f6dfd8","#d3af99","#b2a69b","#b03c49","#ab614c","#e1cd9e","#829563","#438488","#5b637b","#946996","#eba19b","#927160","#615650","#e34a5a","#ea8e60","#e8cb7d","#95cc65","#95e3cc","#567ea5","#c580d8","#ea889f","#7d523c"];
var targetnum = 0;
var loadednum = 0;
var kamooiList = [];


initKamooi();

function initCanvas(){
	canvas=$("#kamooicanvas")[0];
	ctx=canvas.getContext("2d");
	tintcanvas = document.createElement('canvas');
	tintcanvas.width = 256;
	tintcanvas.height = 256;
	ttx = tintcanvas.getContext('2d');
//	haircanvas = document.createElement('canvas');
//	haircanvas.width = 256;
//	haircanvas.height = 256;
//	htx = haircanvas.getContext('2d');
}


function Kamooi(){
//	this.gender = gender;
//this.size = size;
	this.faces = [];
	this.hair = [];
//	this.hairclip = [];
//	this.features = [];
//Will probably add something for outfits. Depends on how much time I have
}

function initKamooi(){
	kamooiList.push(new Kamooi());
 //	kamooiList.push(new Kamooi());
//	kamooiList.push(new Kamooi("male", "reg"));
//	kamooiList.push(new Kamooi("male", "big"));
	targetnum = kamooiList.length*(7+12+12+2.5);
	//targetnum All of the items we're loading... Hair body hats

	//
	for(var i = 0; i < kamooiList.length; i++){
		var kamooi = kamooiList[i];
//Body. Outfits if applicable. 
		for(var j = 1; j <= 7; j++){
			var s = "img/body/"+kamooi.gender+"-"+kamooi.size+"/"+j+".jpg";
			var img = new Image();
			img.onload=function(){
				loadednum++;
				dispload();
			}
			img.src = s;
			kamooi.faces.push(img);
		}

//Loads hair. j iterates through hair numbers.
		for(var j = 1; j <= 1; j++){
			var s = "hair/"+j+".jpg";
			var img = new Image();
			img.onload=function(){
				loadednum++;
				dispload();
			}
			img.src = s;
			kamooi.hair.push(img);
		}	
/*
		for(var j = 1; j <= 12; j++){
			var s = "img/features/"+kamooi.gender+"-"+kamooi.size+"/"+j+".png";
			var img = new Image();
			img.onload=function(){
				loadednum++;
				dispload();
			}
			img.src = s;
			kamooi.features.push(img);
		}
*/
/*
		if(kamooi.gender === "fem"){
			for(var j = 1; j <= 5; j++){
				var s = "img/hairclip/"+kamooi.gender+"-"+kamooi.size+"/"+j+".png";
				var img = new Image();
				img.onload=function(){
					loadednum++;
					dispload();
				}
				img.src = s;
				kamooi.hairclip.push(img);
			}	
		}		
	}
	*/
}

function forward(param){
	if(param === "kamui"){
		currentKamooi = (currentKamooi+1)%kamooiList.length;
	}
	else if(param === "face"){
		var numface = kamooiList[currentKamooi].faces.length;
		currentFace = (currentFace+1)%numface;
	}
	else if(param === "hair"){
		var numhair = kamooiList[currentKamooi].hair.length;
		currentHair = (currentHair+1)%numhair;
	}
	else if(param === "hairclip"){
		if(kamooiList[currentKamooi].gender = "fem"){
			var numclip = kamooiList[currentKamooi].hairclip.length+1;
			currentClip = (currentClip+1)%numclip;
		}
	}
	else if(param === "features"){
		var numfeatures = kamooiList[currentKamooi].features.length+1;
		currentFeature= (currentFeature+1)%numfeatures;
	}
	else if(param === "color"){
		currentColor = (currentColor+1)%colorList.length;
	}
	changeMenu(param);
	loadCurrentKamooi();

}

function backward(param){
	if(param === "kamui"){
		currentKamooi = (currentKamooi+kamooiList.length-1)%kamooiList.length;
	}
	else if(param === "face"){
		var numface = kamooiList[currentKamooi].faces.length;
		currentFace = (currentFace+numface-1)%numface;
	}
	else if(param === "hair"){
		var numhair = kamooiList[currentKamooi].hair.length;
		currentHair = (currentHair+numhair-1)%numhair;
	}
	else if(param === "hairclip"){
		if(kamooiList[currentKamooi].gender = "fem"){
			var numclip = kamooiList[currentKamooi].hairclip.length+1;
			currentClip = (currentClip+numclip-1)%numclip;
		}
	}
	else if(param === "features"){
		var numfeatures = kamooiList[currentKamooi].features.length+1;
		currentFeature= (currentFeature+numfeatures-1)%numfeatures;
		console.log(currentFeature);
	}
	else if(param === "color"){
		currentColor = (currentColor+colorList.length-1)%colorList.length;	
}
	changeMenu(param);
	loadCurrentKamooi();	
}

function loadCurrentKamooi(){
	ctx.clearRect(0,0,255,255);
	var kamooi = kamooiList[currentKamooi];

	ctx.drawImage(kamooi.faces[currentFace],0, 0);
	ctx.drawImage(kamooi.faces[currentFace],0, 0);
	if(currentFeature < 12){
		ctx.drawImage(kamooi.features[currentFeature],0,0);
	}

	var img = kamooi.hair[currentHair];
	drawHair(img);
//{prob dont need this anymore
/*
	if(currentKamooi < 2){
		$("#clipb").prop("disabled",false);
		$("#clipf").prop("disabled",false);
		if(currentClip < 5)
			ctx.drawImage(kamooi.hairclip[currentClip],128,27);
			ctx.drawImage(kamooi.hairclip[currentClip],128,27);
	}else{
		$("#clipb").prop("disabled",true);
		$("#clipf").prop("disabled",true);
	}
*/
}

function drawHair(img){
	
	ttx.clearRect(0,0,256,256);
	if(currentFilter === "hard-light"){	
		ctx.drawImage(img, 0, 0);
		ttx.globalCompositeOperation = "source-over";
		//ttx.drawImage(img, 0, 0);
		//ttx.fillStyle = colorList[currentColor];
		//ttx.fillRect(0,0,256,256);
		//ttx.globalCompositeOperation = "destination-atop";
		//ttx.drawImage(img, 0, 0);
		hairfill(img,colorList[currentColor]);
		ttx.globalCompositeOperation = currentFilter;
		ttx.drawImage(img, 0, 0);

		ctx.drawImage(tintcanvas, 0, 0);
	}
	else if(currentFilter === "overlay"){
		ctx.drawImage(img, 0, 0);
		ttx.globalCompositeOperation = "source-over";
		/*ttx.drawImage(img, 0, 0);
		ttx.fillStyle = colorList[currentColor];
		ttx.fillRect(0,0,256,256);
		ttx.globalCompositeOperation = "destination-atop";
		ttx.drawImage(img, 0, 0);*/
		hairfill(img,colorList[currentColor]);
		ttx.globalCompositeOperation = "source-over";
		

		ctx.globalCompositeOperation = "source-over";
		ctx.drawImage(img, 0, 0);
		ctx.globalCompositeOperation = "overlay";
		ctx.drawImage(tintcanvas, 0, 0);
		ctx.globalCompositeOperation = "source-over";
	}
	ttx.globalCompositeOperation = "source-over";
	ttx.clearRect(0,0,255,255);
}


function hexToRGBA(hex,alpha) {
	var result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
	return result ? {
		r: parseInt(result[1], 16),
		g: parseInt(result[2], 16),
		b: parseInt(result[3], 16),
		a: alpha
	} : null;
}

function dispload(){
	var p = Math.floor(100*(loadednum/targetnum));
	$("#loaderinner").html("Loading... <span>"+p+"</span>%");
	if (p > 75) $("#loaderinner span").css("color","#c3e9f8");
	else if (p > 50)$("#loaderinner span").css("color","#9ad0e6");
	else if (p > 25)$("#loaderinner span").css("color","#78b5cf");

	if(p === 100){
		$("#loader").remove();
	}
}


function changeMenu(param){
	if(param === "kamui"){
		var kgender = (kamooiList[currentKamooi].gender === "fem")?"Female":"Male";
		var ksize = (kamooiList[currentKamooi].size === "reg")?1:2;

		$("#kamooi").html(kgender+" Build "+ksize);

		var clip = $("#clip");
		if(kgender === "Female"){
			if(clip.hasClass("disabled")){
				clip.removeClass("disabled");
				if(currentClip < 5){
					clip.html("Hair Clip "+(currentClip+1));
				}
				else{
					clip.html("None");
				}
			}
		}
		else{
			clip.addClass("disabled");
			clip.html("None");
		}

	}
	else if(param === "face"){
		$("#face").html("Face "+(currentFace+1));
	}
	else if(param === "hair"){
		$("#hair").html("Hair "+(currentHair+1));
	}
	else if(param === "hairclip"){
		var clip = $("#clip");
		if(currentClip < 5){
			clip.html("Hair Clip "+(currentClip+1));
		}
		else{
			clip.html("None");
		}

	}
	else if(param === "features"){
		if(currentFeature < 12){
			$("#features").html("Facial Feature "+(currentFeature+1));
		}
		else{
			$("#features").html("None");
		}
	}
	else if(param === "color"){
		$("#color").html("Hair Color "+(currentColor+1));
	}
}

function setFilterButton(){
	var h = "Current Blend Mode: ";
	if(currentFilter === "overlay") h += "Overlay";
	else h += "Hard Light";
	$("#algo").html(h);
}

function toggleFilter(){
	if(currentFilter === "overlay") currentFilter = "hard-light";
	else currentFilter = "overlay";
	setFilterButton();
	loadCurrentKamooi();
}

function setupHelp(){
	var h = $("#helpinner");
	$("#helpinner").css("top",-h.outerHeight());
	$("#helpmenu").addClass("invis");
}

function closeHelp(){
	var h = $("#helpinner");
	$("#helpinner").animate({top:-h.outerHeight()},{complete:function(){
		$("#helpmenu").addClass("invis");
	}},"fast");
}

function openHelp(){
	$("#helpmenu").removeClass("invis");
	var h = $("#helpinner");
	$("#helpinner").animate({top:0},"fast");
}

function hairfill(img,color){
	ttx.clearRect(0,0,256,256);
	ttx.drawImage(img, 0, 0);
	var imgdata = ttx.getImageData(0,0,256,256);
	var col = hexToRGBA(color);
	var hasColor = function(pos){
		var r = imgdata.data[pos];
		var g = imgdata.data[pos+1];
		var b = imgdata.data[pos+2];
		var a = imgdata.data[pos+3];

		return (a != 0)
	}
	var colorPix = function(pos){
		imgdata.data[pos] = col.r;
		imgdata.data[pos+1] = col.g;
		imgdata.data[pos+2] = col.b;
	}

	for(var i = 0; i < imgdata.data.length;i+=4){
		if(hasColor(i)) colorPix(i);
	}
	ttx.putImageData(imgdata,0,0);
}

$(window).load(function(){
	setupHelp();
	//initHexChart();
	initCanvas();
	setFilterButton();
	changeMenu("kamui");
	changeMenu("face");
	changeMenu("hair");
	changeMenu("hairclip");
	changeMenu("features");
	changeMenu("color");
//	initKamooi();
	loadCurrentKamooi();	
});}
