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

        /* the reason I created this variable is because
           I don´t want to change the old description on the screen before do the update.
         */
        vm.newDescription = '';
        // used to retrieve the Message by id.
        vm.idMessage = '';

        // call GreetingService -> retrieveMessage
        vm.retrieveMessage = function(){
            GreetingService.retrieveMessage().$promise.then(function(data){
                vm.message = {};
                vm.message = data;
                vm.newDescription = vm.message.description;
            },function(data){
                var error = data.data;
                console.log(error);
            })
        }

        // call GreetingService -> updateMessage
        vm.updateMessage = function(){
            // ensure the field is not empty.
            if (!vm.message || !vm.message.description || vm.message.description.length==0){
                console.log("Empty field.")
                return;
            }
            // I created this request instead use the vm.message just in case the service get failure, the actual message still the same.
            var request = {};
            request.id = vm.message.id;
            request.description = vm.newDescription;
            GreetingService.updateMessage(request).$promise.then(function(data){
                vm.message = {};
                vm.message = data;
                vm.newDescription = vm.message.description;
            },function(data){
                var error = data.data;
                console.log(error);
            })
        }

        // call GreetingService -> retrieveMessageByID
        vm.retrieveMessageByID = function(){
            // ensure that the id is greater than 0.
            if (vm.idMessage<1){
                console.log("Invalid ID.")
                return;
            }
            GreetingService.retrieveMessageByID(vm.idMessage).$promise.then(function(data){
                vm.message = {};
                vm.error = '';
                vm.message = data;
                vm.newDescription = vm.message.description;
            },function(data){
                vm.message = {};
                vm.newDescription = '';
                vm.error = "Message ID not found!!";
                var error = data.data;
                console.log(error);
            })
        }
    }

})();
