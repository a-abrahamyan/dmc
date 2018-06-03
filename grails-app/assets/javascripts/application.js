// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require bootstrap
//= require_tree .
//= require_self

var clickEvent = 0;

if (typeof jQuery !== 'undefined') {
    (function ($) {
        $(document).ajaxStart(function () {
            $('#spinner').fadeIn();
        }).ajaxStop(function () {
            $('#spinner').fadeOut();
        });
    })(jQuery);
}

$(document).ready(function () {
    disableOptionalFields();
});

function disableOptionalFields() {
    var fieldsArray = ["highLDLValue", "inheritance", "_inheritance", "smoking", "_smoking", "noAccused", "_noAccused", "leftCoronaryArtery", "_leftCoronaryArtery", "rightCoronaryArtery", "_rightCoronaryArtery", "frontLandingArtery", "_frontLandingArtery", "aorticArch", "_aorticArch"];
    var reopened = $(".errors li").length !== 0 || $("#edit-person").length !== 0;
    var uncheckedFields = "";

    $(".form input").each(function () {
        if (fieldsArray.indexOf($(this).attr("name")) !== -1) {

            var label = $(this).parent().find("label");
            var valueNotEmpty = false;

            if (reopened) {
                uncheckedFields = $("#unCheckedFields").val()
            }

            if (label.parent().find("input").attr("name") === "highLDLValue") {
                valueNotEmpty = $(this).val().length !== 0
            } else {
                valueNotEmpty = !(uncheckedFields.indexOf($(label.parent().find("input")[1]).attr("name")) >= 0)
            }

            if (!(reopened && valueNotEmpty)) {
                $(this).attr('disabled', 'disabled');
                label.css('color', 'rgba(0, 0, 0, 0.34)');
                label.addClass('disabledForTime');
            }

            label.on("click", function (e) {
                if (clickEvent === 1) {
                    clickEvent = 0;
                    label.parent().find("input").each(function (index, element) {
                        $(element).prop('checked', false);
                    });
                    return true;
                }

                if (label.hasClass('disabledForTime')) {
                    label.parent().find("input").removeAttr('disabled');
                    label.removeClass('disabledForTime');
                    label.css('color', 'black');
                } else {
                    label.parent().find("input").each(function (index, element) {
                        $(element).attr('disabled', 'disabled');
                        $(element).val('');
                    });
                    label.css('color', 'rgba(0, 0, 0, 0.34)');
                    label.addClass('disabledForTime');
                }

                if (label.parent().find("input").attr("id") !== "highLDLValue") {
                    clickEvent ++;
                }
            })
        }
    })
}

