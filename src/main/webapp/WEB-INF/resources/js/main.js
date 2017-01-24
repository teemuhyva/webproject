/**
 * Created by Teemu on 04/01/2017.
 */

$(document).ready(function () {
    $('#click').click(function () {
        $('.targetIncrement').toggle();
        $('.targetDecrement').toggle();
    });


    $('input.targetIncrement').click(function add( ) {
        var totalG = $(this).next().val();
        totalG++
        $(this).next().val(totalG);

    });

    $('input.targetDecrement').click(function subst() {
        var totalG = $(this).prev().val();

        if(totalG >= 1) {
            totalG--;
            $(this).prev().val(totalG);
        }
    });
});