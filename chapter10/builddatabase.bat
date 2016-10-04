call manage remove Employee extent
call manage remove Address extent

call manage add Employee 1 Rick Sperko rick@sperko.com
call manage add Employee 2 Ed Chaltry ed.chaltry@centare.com
call manage add Employee 3 Dave Glyzewski dave.glyzewski@centare.com

call manage add Address 1 "111 N. East Rd." "" Milwaukee WI
call manage add Address 2 "15800 W. South Rd." "Suite 305" Brookfield WI

call manage assoc Employee "id==1" Address "id==1"
call manage assoc Employee "id==2" Address "id==2"
call manage assoc Employee "id==3" Address "id==2"

call manage list Employee extent
call manage list Address extent