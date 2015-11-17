/**
 * Created by Gabriel on 16/11/2015.
 */


(function() {
    'use strict';

    angular
        .module('greetingApp')
        .controller('greetingController', greetingController);

    greetingController.$inject = ['$scope','GreetingService','MessageGlobal'];

    function greetingController($scope,GreetingService, MessageGlobal) {
        // vm => view model (controller)
        /* jshint validthis: true */
        var vm = this;

        // call GreetingService -> retrieveMessage
        vm.retrieveMessage = function(){
            GreetingService.retrieveMessage().$promise.then(function(data){
                MessageGlobal.reset();
                vm.message = {};
                vm.message = data;
            },function(data){
                var error = data.data;
                console.log(error);
            })
        }
    }

})();
