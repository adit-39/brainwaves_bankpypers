from flask import Flask,json
import utils

app = Flask(__name__)

@app.route('/api/authorize/<name>')
def salt(name):
	x=utils.get_salt(name)
	return json.dumps(x)

@app.route('/api/authorize/<name>/<passwd>')
def authorize(name,passwd):
	b=utils.verify(name,passwd)
	return json.dumps(b)

@app.route('/api/get_est_time/<activities>')
def get_est_time(activities):
	rem_time=utils.get_time(activities)
	return json.dumps(rem_time)

if __name__ == '__main__':
    app.run(host='0.0.0.0',debug=True, port=5001)
