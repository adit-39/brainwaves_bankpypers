import sqlite3 as sq

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
	#print key
	if key[0]==passwd:
		return "TRUE"
	else:
		return "FALSE"
