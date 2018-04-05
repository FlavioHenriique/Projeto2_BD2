$('#myModal').on('shown.bs.modal', function () {
  $('#myInput').trigger('focus')
});

$('#myCollapsible').collapse({
  toggle: false
})