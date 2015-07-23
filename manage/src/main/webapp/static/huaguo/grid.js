$(function() {
	$objs = $("[data-role=hggrid]");
	$objs.each(function() {
		$(this).hgGrid();
	});
})

jQuery.fn.extend({
	hgGrid : function(option) {
		var _this = $(this),
			url = _this.data("url"),
			localdata = _this.data("localdata"),
			datatype = _this.data("datatype"),
			colNames = new Array(),
			colModel = new Array(),
			width = _this.data("width"),
			viewrecords = _this.data("viewrecords"),
			caption = _this.data("caption"),
			height = _this.data("height"),
			multiselect = _this.data("multiselect"),
			pager = _this.data("pager"),
			sortname = _this.data("sortname"),
			sortorder = _this.data("sortorder"),
			headerViews = _this.find("thead tr th"),
			gridOption = new Object(),
			gboxView,
			gboxWidth,
			pagerObj,
			pagerOption = new Object();
		// init cols option
		headerViews.each(function() {
			var _this = $(this),
				title = _this.text(),
				key = _this.data("key"),
				name = _this.data("name"),
				index = _this.data("index"),
				width = _this.data("width"),
				align = _this.data("align"),
				fixed = _this.data("fixed"),
				sortable = _this.data("sortable"),
				editable = _this.data("editable"),
				resize = _this.data("resize"),
				formatter = _this.data("formatter"),
				formatoptions = _this.data("formatoptions"),
				formatterCustom = _this.data("formatter-custom"),
				_colModel = new Object();
			if(key != null) {
				_colModel.key = key;
			}
			if(name != null) {
				_colModel.name = name;
			}
			if(index != null) {
				_colModel.index = index;
			}
			if(width != null) {
				_colModel.width = width;
			}
			if(formatter != null) {
				if(formatterCustom) {
					_colModel.formatter = window[formatter];
				} else {
					_colModel.formatter = formatter;
				}
			}
			colNames.push(title);
			colModel.push(_colModel);
		});
		
		// init jqgrid option
		if(url != null) {
			gridOption.url = url;
		}
		if(datatype != null) {
			gridOption.datatype = datatype;
		}
		if(width != null) {
			gridOption.width = width;
		}
		if(height != null) {
			gridOption.height = height;
		}
		if(multiselect != null) {
			gridOption.multiselect = multiselect;
		}
		if(viewrecords != null) {
			gridOption.viewrecords = viewrecords;
		}
		if(caption != null) {
			gridOption.caption = caption;
		}
		if(pager != null && datatype !== "local") {
			gridOption.pager = pager;
		}
		if(sortname != null) {
			gridOption.sortname = sortname;
		}
		if(sortorder != null) {
			girdOption.sortorder = sortorder;
		}
		gridOption.colNames = colNames;
		gridOption.colModel = colModel;
		
		if(option != null) {
			$.extend(gridOption, option);
		}

		// construct jqgrid
		_this.jqGrid(gridOption);
		
		// if datatype is 'local', init grid with localdata
		if(datatype === "local" && localdata != null) {
			for(var i = 0; i <= localdata.length; i++) {
				_this.jqGrid('addRowData', i + 1, localdata[i]);
			}
			// init local custom pager
			if(pager != null) {
				gboxView = $("#gbox_" + _this.attr("id"));
				gboxWidth = gboxView.removeClass("ui-corner-all").addClass("ui-corner-top").width();
				pagerOption.id = pager;
				pagerOption.gboxView = gboxView;
				pagerObj = new Pager(pagerOption).render();
			}
		}
	}
});


function Pager(config) {
	this.id = config.id;
	this.gboxView = config.gboxView;
	this.width = this.gboxView.width();
	this.view = $("#" + this.id).addClass("ui-state-default ui-jqgrid-pager ui-cornor-bottom").css("width", this.width + "px").attr("dir", "ltr");
	this.total = this.view.data("total");
	if(this.total == null) this.total = 1;
	this.current = this.view.data("current");
	if(this.current == null) this.current = 1;
}
Pager.defaults = {
	paramPage : "page",
	paramRows : "rows"
}
$.extend(Pager.prototype, {
	render : function() {
		var subViewStr = '<div id="pg_' + this.id + ' class="ui-pager-control" role="group">';
		subViewStr += '<table class="ui-pg-table" cellspacing="0" cellpadding="0" border="0" role="row" style="width:100%;table-layout:fixed;height:100%;"><tbody><tr>';
		// left side
		subViewStr += '<td id="' + this.id + '_left" algin="left"><table class="ui-pg-table navtable" cellspacing="0" cellpadding="0" border="0" style="float:left;table-layout:auto;"><tbody><tr>';
		subViewStr += '</tr></tbody></table></td>';
		// center side
		subViewStr += '<td id="' + this.id + '_center" align="center" style="white-space:pre;width:244px;"><table class="ui-pg-table" cellspacing="0" cellpadding="0" border="0" style="table-layout:auto;"><tbody><tr>';
		subViewStr += this.getButtonViewStr('first', 'first');
		subViewStr += this.getButtonViewStr('prev', 'prev');
		subViewStr += '<td class="ui-pg-button ui-state-disabled" style="width:4px;cursor:default;"><span class="ui-separator"></span></td>';
		subViewStr += '<td dir="ltr"><input class="ui-pg-input" type="text" role="textbox" value="' + this.current + '" maxlength="7" size="2"> / <span id="sp_1_' + this.id + '">' + this.total + '</span></td>';
		subViewStr += '<td class="ui-pg-button ui-state-disabled" style="width:4px;cursor:default;"><span class="ui-separator"></span></td>';
		subViewStr += this.getButtonViewStr('next', 'next');
		subViewStr += this.getButtonViewStr("last", 'end');
		subViewStr += '</tr></tbody></table></td>';
		// right side
		subViewStr += '<td id="' + this.id + '_right" align="right"><div class="ui-paging-info" style="text-align:right" dir="ltr"></div></td>';
		subViewStr += '</tr></tbody></table></div>';
		this.view.append(subViewStr).appendTo(this.gboxView);
		this.checkButtonState();
		this.bindEvent();
	},
	changeLocationPage : function(newPageNo) {
		var paramPage = Pager.defaults.paramPage,
			paramRows = Pager.defaults.paramRows,
			path = window.location.toString().split("?")[0],
			searchPath = window.location.search.toString(),
			searchParts,
			temp,
			i;
		if(searchPath == null || searchPath == "") {
			// original search is blank
			searchPath = "?" + paramPage + "=" + newPageNo;
		} else {
			// original search is not blank, replace or add the param 'page'
			searchParts = searchPath.replace("?", "").split("&");
			// replace if original search contains the param 'page'
			for(i = 0; i < searchParts.length; i++) {
				if(searchParts[i].indexOf(paramPage) > -1) {
					searchParts[i] = paramPage + "=" + newPageNo;
				}
			}
			searchPath = "?" + searchParts.join("&");
			// add if original search does not contain the param 'page'
			if(searchPath.indexOf(paramPage) < 0) {
				searchPath += paramPage + "=" + newPageNo;
			}
		}
		// the grid component paging
		window.location.href = path + searchPath;
	},
	bindEvent : function() {
		var _this = this,
			currentInput = this.view.find('.ui-pg-input');
		currentInput.change(function() {
			var value = $(this).val();
			if(value < 1 || value > _this.total) {
				return false;
			}
			_this.changeLocationPage(value);
		});
	},
	_onClickEvent : function(btnName) {
		var _this = this,
			btnView = this.getButtonView(btnName),
			path = window.location.toString().split("?")[0];
		if(btnName === "first") {
			btnView.on("click", function() {
				_this.changeLocationPage(1);
			});
		}
		if(btnName === "prev") {
			btnView.on("click", function() {
				_this.changeLocationPage(_this.current - 1);
			});
		}
		if(btnName === "next") {
			btnView.on("click", function() {
				_this.changeLocationPage(_this.current + 1);
			});
		}
		if(btnName === "last") {
			btnView.on("click", function() {
				_this.changeLocationPage(_this.total);
			});
		}
	},
	checkButtonState : function() {
		var firstBtn = this.getButtonView("first"),
			prevBtn = this.getButtonView("prev"),
			nextBtn = this.getButtonView("next"),
			lastBtn = this.getButtonView("last"),
			currentInput = this.view.find('.ui-pg-input');
		if(this.current > 1) {
			this.enableButton("first");
			this.enableButton("prev");
		}
		if(this.current < this.total) {
			this.enableButton("next");
			this.enableButton("last");
		}
		if(this.current === 1) {
			this.disableButton("first");
			this.disableButton("prev");
		}
		if(this.current === this.total) {
			this.disableButton("next");
			this.disableButton("last");
		}
	},
	disableButton : function(btnName) {
		var btnView = this.getButtonView(btnName);
		if(!btnView.hasClass("ui-state-disabled")) {
			btnView.addClass("ui-state-disabled");
			btnView.off("click");
		}
	},
	enableButton : function(btnName) {
		var btnView = this.getButtonView(btnName);
		if(btnView.hasClass("ui-state-disabled")) {
			btnView.removeClass("ui-state-disabled");
			this._onClickEvent(btnName);
		}
	},
	getButtonView : function(btnName) {
		return this.view.find('#' + btnName + '_' + this.id);
	},
	getButtonViewStr : function(btnName, className) {
		return '<td id="' + btnName + '_' + this.id + '" class="ui-pg-button ui-corner-all ui-state-disabled" style="cursor:default;"><span class="ui-icon ui-icon-seek-' + className + '"><span></td>';
	},
	getSeparatorViewStr : function() {
		return '<td class="ui-pg-button ui-state-disabled" style="width:4px;cursor:default;"><span class="ui-separator"></span></td>';
	}
});