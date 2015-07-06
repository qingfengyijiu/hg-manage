function Nav(config) {
	this.url = config.url;
	this.children = config.children;
	this.view = null;
	this.childView = null;
	this.collapseState = true;
}
Nav.defaults = {
	view : {
		li : "<li></li>",
		acitveClass : "active",
		hasChildrenClass : "hasChildren",
		hasChildrenIconClass : "arrow fa",
		hasChildrenCollapseClass : "fa-chevron-right",
		hasChildrenOpenClass : "fa-chevron-up",
	}
}
$.extend(Nav.prototype, {
	render : function() {
		
	},
	hasChildren : function() {
		if(this.children != null && this.children.size > 0) {
			return true;
		}
		return false;
	},
	open : function() {
		if(!hasChildren) return;
		this.childView.show();
		this.view.removeClass(Nav.defaults.view.hasChildrenCollapseClass);
		this.view.addClass(Nav.defaults.view.hasChildrenOpenClass);
		this.collapseState = false;
	},
	collapse : function() {
		if(!hasChildren || this.collapseState) return;
		this.childView.hide();
		this.view.removeClass(Nav.defaults.view.hasChildrenOpenClass);
		this.view.addClass(Nav.defaults.view.hasChildrenCollapseClass);
	}
});