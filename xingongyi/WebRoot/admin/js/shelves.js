/**
 * Created by Fish on 2016/1/13.
 */
var shelves = {};
shelves.domIntroduce = '<div class="introduce row mar-top-15">' +
                        '<div class="col-sm-3">' +
                        '<input class="form-control" type="text" placeholder="属性名" name="">' +
                        '</div>' +
                        '<div class="col-sm-3">' +
                        '<input class="form-control" type="text" placeholder="属性" name="">' +
                        '</div>' +
                        '<div class="col-sm-3">' +
                        ' <button type="button" class="btn delete-introduce btn-danger"><i class="icon icon-remove-sign"></i></button>' +
                        '</div>' +
'</div>';
shelves.domSpecifications = '<div class="specifications row mar-top-15">' +
    '<div class="col-sm-3 col-sm-offset-3">' +
    '<input class="form-control" type="text" placeholder="规格" name="">'+
    '</div>'+
    '<div class="col-sm-3">'+
    '<input class="form-control" type="text" placeholder="价格" name="">'+
    '</div>'+
    '<div class="col-sm-3">'+
    '<button type="button" class="btn delete-specifications btn-danger"><i class="icon icon-remove-sign"></i></button>'+
    '</div>'+
    '</div>';
shelves.addIntroduce =  $('.add-introduce');
shelves.deleteIntroduce = $('.delete-introduce');
shelves.bodyIntroduce = $('.introduce-body');
shelves.addSpecifications = $('.add-specifications');
shelves.deleteIntroduce = $('.delete-specifications');
shelves.bodySpecifications = $('.specifications-body');
shelves.heightControl = function () {
    $(window.parent.document).find('iframe').height($('body').height());
};
    shelves.addIntroduce.click(function () {
        shelves.bodyIntroduce.append(shelves.domIntroduce);
        shelves.heightControl();
    });
    shelves.addSpecifications.click(function () {
        shelves.bodySpecifications.append(shelves.domSpecifications);
        shelves.heightControl();
    });
    shelves.bodyIntroduce.on('click','.delete-introduce', function () {
        $(this).parents('.introduce').remove();
    });
    shelves.bodySpecifications.on('click','.delete-specifications', function () {
        $(this).parents('.specifications').remove();
    });