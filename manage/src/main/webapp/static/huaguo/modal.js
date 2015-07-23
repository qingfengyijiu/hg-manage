// because bootstrap modal is implemented by ajax request and  then assembled,
// we are hard to change the content after the modal is assembled. So I decide to use bootstrap modal
// for once use dialog, that is each modal is used for one static dialog content. If you need to show 
// many kinds of dialog content, you need construct many modals for each kind.
jQuery.extend({
	hgModal : function(config) {
		var view = $("#hgModal"),
			titleId,
			remote,
			html,
			modalOption = new Object();
		// show modal with options
		if(typeof config === "object") {
			titleId = config.titleId;
			remote = config.remote;
			html = config.html;
			width = config.width;
			// one page one modal, remove the existing modal
			if(view.size() > 0) {
				view.remove();
			}
			view = $('<div id="hgModal" class="modal fade" role="dialog" aria-labelledby="' + titleId + '"><div class="modal-dialog"><div class="modal-content"></div></div></div>');
			// init dialog width
			if(width != null) {
				view.find(".modal-dialog").width(width);
			}
			view.appendTo("body");
			modalOption.show = true;
			if(remote != null) {
				modalOption.remote = remote;
				modalOption.width = 900;
				view.modal(modalOption);
			}
		}
		// close modal
		if(typeof config === "string") {
			if(config === "close") {
				view.modal("close");
			}
		}
	}
})