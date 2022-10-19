/**
 * 
 */

(function () {
    var previous;

    $("select").on('focus', function () {
        // Store the current value on focus and on change
        previous = this.value;
    }).change(function() {
        // Do something with the previous value after the change
        alert(previous);

        // Make sure the previous value is updated
        previous = this.value;
    });
})();