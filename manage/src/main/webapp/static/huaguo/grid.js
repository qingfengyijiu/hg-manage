$(function() {
	$objs = $("[data-role=hggrid]");
	$objs.each(function() {
		var _this = $(this),
			url = _this.data("url"),
			localdata = _this.data("localdata");
			datatype = _this.data("datatype"),
			colNames = new Array(),
			colModels = new Array(),
			width = _this.data("width"),
			viewrecords = _this.data("viewrecords"),
			caption = _this.data("catpion"),
			height = _this.data("height"),
			pager = _this.data("pager"),
			sortname = _this.data("sortname"),
			sortorder = _this.data("sortorder"),
			headerViews = _this.children("thead tr th"),
			gridOption = new Object();
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
				colModel = new Object();
			if(key != null) {
				colModel.key = key;
			}
			if(name != null) {
				colModel.name = name;
			}
			if(index != null) {
				colModel.index = index;
			}
			if(width != null) {
				colModel.width = width;
			}
			if(formatter != null) {
				if(formatterCustom) {
					colModel.formatter = window[formatter];
				} else {
					colModel.formatter = formatter;
				}
			}
			colNames.add(title);
			colModels.add(colModel);
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
		if(viewrecords != null) {
			gridOption.viewrecords = viewrecords;
		}
		if(caption != null) {
			gridOption.caption = caption;
		}
		if(pager != null) {
			gridOption.pager = pager;
		}
		if(sortname != null) {
			gridOption.sortname = sortname;
		}
		if(sortorder != null) {
			girdOption.sortorder = sortorder;
		}
		gridOption.colNames = colNames;
		gridOption.colModels = colModels;
		
		_this.jqGrid(gridOption);
		// if datatype is 'local', init grid with localdata
		if(datatype === "local" && localdata != null) {
			for(var i = 0;i <= localdata.length; i++) {
				_this.jqGrid('addRowData', i + 1, localdata[i]);
			}
		}
	});
})