import sqlite3 as sq
from datetime import datetime,timedelta


count = 0

def get_salt(name):
	con=sq.connect('socGen_local')
	cur=con.cursor()
	cur.execute('select salt from auth where user_name=(?)',(name,))
	x=cur.fetchone()
	if x==None:
		return("NULL")
	return x

def verify(name,passwd):
	con=sq.connect('socGen_local')
	cur=con.cursor()
	cur.execute('select password from auth where user_name=(?)',(name,))
	key=cur.fetchone()
	if key[0]==passwd:
		return "TRUE"
	else:
		return "FALSE"

def get_time(activities):
	global count
	count+=1
	l=activities.split('-')
	x=len(l)
	adnl_del=x*60
	# need to get learning data here
	# withdraw , deposit , DD+RTGS, loan
	seconds=adnl_del
	for i in l:
		if i=='withdraw' or i=='deposit':
			seconds+=150
		if i=='loan':
			seconds+=1500

	print(seconds)
	sec = datetime(1,1,1,0,0,0)
	d = timedelta(0,seconds) + sec
	res = "%d:%d:%d:%d" % (d.day-1, d.hour, d.minute, d.second)
	return res
		
