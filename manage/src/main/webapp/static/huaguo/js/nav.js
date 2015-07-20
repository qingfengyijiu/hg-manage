var hgNav = {};
hgNav.defaults = {
	style : {
		navClass : "huaguo-nav",
		acitveClass : "active",
		hasChildrenClass : "has-children",
		hasChildrenIconClass : "arrow fa fa-chevron-right",
		openClass : "open",
	}
};
hgNav.render = function(target, data) {
	var _defaultStyle = hgNav.defaults.style,
		_tag = target[0].tagName.toLowerCase(),
		_ul,
		_nav;
	if(_tag === "ul") {
		hgNav._render(target, data);
	} else if(_tag === "nav") {
		_ul = $("<ul></ul>");
		hgNav.render(_ul, data);
		_ul.appendTo(target);
	} else {
		_nav = $('<nav class="' + _defaultStyle.navClass + '"></nav>');
		hgNav.render(_nav, data);
		_nav.appendTo(target);
	}
}
hgNav._render = function(target, data) {
	var _defaultStyle = hgNav.defaults.style,
		_data,
		_children,
		_url,
		_title,
		_view,
		_ul;
	for(var i = 0; i < data.length; i++) {
		_data = data[i],
		_children = _data["children"],
		_view,
		_ul;
		if(_children != null && _children.length > 0) {
			_view = $('<li class="' + _defaultStyle.hasChildrenClass + '"><a href="' + _data.url + '"><span>' + _data.title +  '</span><i class="' + _defaultStyle.hasChildrenIconClass + '"></i></a></li>');
			_ul = $("<ul><ul>");
			hgNav._render(_ul, _children);
			_view.append(_ul);
		} else {
			_view = $('<li><a href="' + _data.url + '"><span>' + _data.title +  '</span></a></li>');
		}
		_view.appendTo(target);
	}
}
jQuery.fn.extend({
	hgNav : function(data) {
		var _defaultStyle = hgNav.defaults.style,
			openClass = _defaultStyle.openClass;
		hgNav.render($(this), data);
		$("." + _defaultStyle.navClass + " li." + _defaultStyle.hasChildrenClass).on("click", function() {
			var _this = $(this);
			if(_this.hasClass(openClass)) {
				_this.removeClass(openClass);
				_this.children("ul").hide();
			} else {
				_this.addClass(openClass);
				_this.children("ul:first").show();
			}
		});
	}
});
