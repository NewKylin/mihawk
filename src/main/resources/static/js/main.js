var usrName = 'usr'
var nowPosition = '~'
var commandList = 'cd ls cat logout hey hi hello help clear exit ~ / ./'.split(' ')
var hisCommand = []
var cour = 0
var isInHis = 0
var directory = []
var files = []

var e_main = $('#main')
var e_input = $('.input-text')
var e_html = $('body,html')
var e_pos = $('#pos')

 mainFunc = (input, position) =>
 {
   if (input === '') {
     e_main.html($('#main').html() + '[<span id="usr">' + usrName + '</span>@<span class="host">ursb.me</span> ' + position + ']% ' + '<br/>')
     e_html.animate({scrollTop: $(document).height()}, 0)
   } else {
     $.ajax({
       url: '/RedisClient/command',
       data: {command: input},
       //dataType: 'jsonp',
       success: function (res) {
         e_main.html($('#main').html() + '<br/>'+ '[<span id="usr">' + usrName + '</span>@<span' +
             ' class="host">ursb.me</span> ' + position + ']% ' + input + '<br/>' + res);
       },
     });
   }
 }



window.onresize = function () {
  e_input.width($(document).width() - $('.prefix').width() - 160)
};


$(document).bind('keydown', function (b) {
  e_input.focus()
  if (b.keyCode === 13) {
    e_main.html($('#main').html())
    e_html.animate({ scrollTop: $(document).height() }, 0)
    mainFunc(e_input.val(), nowPosition)
    hisCommand.push(e_input.val())
    isInHis = 0
    e_input.val('')
  }
  if (b.keyCode === 9) {
    pressTab(e_input.val())
    b.preventDefault()
    e_html.animate({ scrollTop: $(document).height() }, 0)
    e_input.focus()
  }

  if (b.keyCode === 38) historyCmd('up')
  if (b.keyCode === 40) historyCmd('down')

  // Ctrl + U 清空输入快捷键
  if (b.keyCode === 85 && b.ctrlKey === true) {
    e_input.val('')
    e_input.focus()
  }
})