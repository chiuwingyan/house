$(document).ready(function(){
	$(window).on("load",function(){
		$('#tasksSideList').collapse('hide');
		fixLayout();
		loadContent('dashboard');
		tasks.update();
	});
	$(window).on("resize",function(){
		fixLayout();
	});	


	//FLIP SIDEBAR ACTIVE
	$('.sideBar>ul>li>figure:first-child').on("click",function(){
		if(!$(this).parent().find('.subSide').length){
			$('.subSide').slideUp();
		}
		var ac = $('.sideBar > ul >li.active')[0];
		$(this).parent().addClass('active');
		$(ac).removeClass('active');
		
	});

	//BIND DROPPER SIDEBAR ACTIONS
	$('.sideBar > ul > li.dropper >figure:first-child').on("click",function(){
		$(this).parent().find('.subSide').slideToggle(300);
		var ac = $('.sideBar > ul >li.active')[0];
		
		var par = $(this).parent()[0];
		$(ac).removeClass('active');
		$(par).addClass('active');
	});

	//Switch NavLinks Activation State
	$('.nav li').on("click",function(e){
		var active = $('.nav li.active')[0];
		$(active).removeClass('active');
		$(this).addClass('active');
	});

	//Bind Tooltips With Anchors only on Navbar
	$(".navbar a[rel='tooltip']").tooltip({
		placement:'bottom',
		trigger:'hover',
		animation:'true'
	});

	

	//Bind Content Loading Script
	$('.sideBar li').on("click",function(){
		var dt = $(this).attr('data-target');
		$.ajax({
			url:'pages/'+dt+'.html',
			cache:false,
			success:function(data){
				$('.content').empty();
				$('.content').html(data);
			}
		}).done(function(d){
			updateTooltips();
		});
	});	




	//Testing Page Stuff
	$('#loadContentTestButton').live("click",function(){
		var target = $('#loadContentTestText')[0].value;
		loadContent(target);
	});


	$("#addProjectAdd").live("click",function(){
		addProject({
			id:$('.table-projects').find('tr:last-child td:nth-child(1)').text()+1,
			name:$("#addProjectName")[0].value,
			client:$('#addProjectClient')[0].value,
			desc: $('#addProjectDesc')[0].value,
			messages:"0",
			files:"0",
			tasks:"0",
			completion:"80%"
		});
		console.log('Added Project');
		alert('Project Added, Update the Details Using updateProject() function');
	});

	$("#testAddMiniTask").live("click",function(){
		tasks.add(
			$("#testTask")[0].value,
			$("#testTaskState")[0].value
		);
	});
	$("#testRemoveMiniTask").live("click",function(){
		tasks.remove(
			$("#testTaskRemoveId")[0].value
		);
	});
	$("#testChangeMiniTask").live("click",function(){
		tasks.changeTask(
			$("#testTaskChangeId")[0].value,
			$("#testChangeTask")[0].value
		);
	});
	$("#testUpdateMiniTask").live("click",function(){
		tasks.updateState(
			$("#testTaskUpdateId")[0].value,
			$("#testUpdateState")[0].value
		);
	});

});




function fixLayout(){
	$('.content').css('height',getDocHeight()-40+'px');
	$('.sideBar').css('height',getDocHeight()-70+'px');
}

//Call this function after updating data that contains tooltips
function updateTooltips(){
	//Bind Tooltips with Buttons
	$("button[rel='tooltip']").tooltip({
		placement:'top',
		trigger:'hover',
		animation:'true'
	});
}


//This function is for custom triggering of sidebar content targets 
//Usage .. 
// loadContent('dashboard')
// or
// loadContent('tables')
// etc.
// If you run into problem... I'm Always Here :) ... Contact me at nanu.clickity@gmail.com
function loadContent(_targetKey){
	$.ajax({
		url:'pages/'+_targetKey+'.html',
		cache:false,
		success:function(data){
			$('.content').empty();
			$('.content').html(data);
		}
	});
}


//Call this function to add data to project Table
function addProject(_object){
	var tr = new dummy.project();
	tr.find("td:first-child").text(_object.id);
	tr.find("td:nth-child(2)").text(_object.name);
	tr.find("td:nth-child(3)").text(_object.client);
	tr.find("td:nth-child(4)").text(_object.desc);
	tr.find("td:nth-child(5) button:nth-child(1)").html("<i class='icon-white icon-envelope'></i> "+_object.messages);
	tr.find("td:nth-child(5) button:nth-child(2)").html("<i class='icon-white icon-file'></i> "+_object.files);
	tr.find("td:nth-child(5) button:nth-child(3)").html("<i class='icon-white icon-edit'></i> "+_object.tasks);
	tr.find("td:nth-child(6) .bar").css('width',_object.completion);

	$('.table-projects').append(tr);
	updateTooltips();
}








/*--------------- TASKS MODULE --------------*/
var tasks = {
	updateIcons: function(){
		//Remove Previous Icons
		$("#tasksSideList li").find('i').each(function(index){$(this).remove();});

		//For Task Completed
		$("#tasksSideList li[data-taskState='0']").prepend("<i class='icon-remove'></i> ");
		//For Task Incomplete
		$("#tasksSideList li[data-taskState='1']").prepend("<i class='icon-ok'></i> ");
	},
	add: function(data,state){
		var taskItem = $("<li/>").text(data)
						.attr('data-taskId',parseInt($("#tasksSideList").find('li:first-child').attr('data-taskId'))+1)
						.attr('data-taskState',state.toString());
		//Prepend to TasksSideList
		$('#tasksSideList').prepend(taskItem);

		tasks.update();
	},
	remove: function(taskid){
		$('#tasksSideList li').each(function(index){
			if(parseInt($(this).attr('data-taskId'))==parseInt(taskid)){
				$(this).remove();
			}
		});
		tasks.update();
	},
	updateState: function(taskid,taskstate){
		$('#tasksSideList li').each(function(index){
			if(parseInt($(this).attr('data-taskId'))==parseInt(taskid)){
				$(this).attr('data-taskState',taskstate.toString());
			}
		});
		tasks.update();
	},
	changeTask: function(taskid,task){
		$('#tasksSideList li').each(function(index){
			if(parseInt($(this).attr('data-taskId'))==parseInt(taskid)){
				$(this).text(task);
			}
		});
		tasks.update();
	},
	updateNumbers: function(){
		$('#tasksSideList li').each(function(index){
			var space = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20];  //Mini List Should not have more than 20 tasks
			for(var j=0;j<space.length;j++){
				var ck = space[j].toString()+". ";
				if( ($(this).text().indexOf(ck)+1) > 0){
					$(this).text( $(this).text().replace(ck,'') );
				}
			}
			var taskId = $(this).attr('data-taskId')+". ";
			$(this).prepend(taskId.toString());
		});
	},
	update: function(){
		tasks.updateNumbers();
		tasks.updateIcons();
	}

};








/* --------- FEATURED ON JAMES PADOLSEY's Website ------------*/
function getDocHeight() {
    var D = document;
    return Math.max(
        Math.max(D.body.scrollHeight, D.documentElement.scrollHeight),
        Math.max(D.body.offsetHeight, D.documentElement.offsetHeight),
        Math.max(D.body.clientHeight, D.documentElement.clientHeight)
    );
}
function getDocWidth() {
    var D = document;
    return Math.max(
        Math.max(D.body.scrollWidth, D.documentElement.scrollWidth),
        Math.max(D.body.offsetWidth, D.documentElement.offsetWidth),
        Math.max(D.body.clientWidth, D.documentElement.clientWidth)
    );
}


/*----------- DUMMY OBJECTS -------------*/
dummy = {};
dummy.project = function () { return $("<tr/>").html("<td>__id__</td><td>__name__</td><td>__client__</td><td>__desc__</td><td><div class='btn-group sharp'><button class='btn btn-primary' rel='tooltip' title='Messages'><i class='icon-white icon-envelope'></i> __messages__</button><button class='btn btn-primary' rel='tooltip' title='Files'><i class='icon-white icon-file'></i> __files__</button><button class='btn btn-primary' rel='tooltip' title='Tasks'><i class='icon-white icon-edit'></i> __tasks__</button></div></td><td><div class='progress progress-success'><div class='bar' style='width:__completion__'></div></div></td>");}