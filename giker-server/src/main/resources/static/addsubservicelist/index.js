i=1;
$(".target").hide();
  $(".container"+i).on("mouseover",function() {
  $(".target"+i).show();
});
$(".container"+i).on("mouseout",function() {
  $(".target"+i).hide();
});

for(int i=2;i<=10;i++){
$(".target").hide();
  $(".container"+i).on("mouseover",function() {
  $(".target"+i).show();
});
$(".container"+i).on("mouseout",function() {
  $(".target"+i).hide();
});}
//
//$(".container2").on("mouseover",function() {
//$(".target2").show();
//});
//$(".container2").on("mouseout",function() {
//$(".target2").hide();
//});
//
//$(".container3").on("mouseover",function() {
//$(".target3").show();
//});
//$(".container3").on("mouseout",function() {
//$(".target3").hide();
//});
//
//$(".container4").on("mouseover",function() {
//$(".target4").show();
//});
//$(".container4").on("mouseout",function() {
//$(".target4").hide();
//});
//
//$(".container5").on("mouseover",function() {
//$(".target5").show();
//});
//$(".container5").on("mouseout",function() {
//$(".target5").hide();
//});
