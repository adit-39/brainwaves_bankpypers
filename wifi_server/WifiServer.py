from flask import Flask,json
import utils

app = Flask(__name__)

@app.route('/api/authorize/<name>')
def salt(name):
	x=utils.get_salt(name)
	return json.dumps(x[0])

@app.route('/api/authorize/<name>/<passwd>')
def authorize(name,passwd):
	b=utils.verify(name,passwd)
	return json.dumps(b)

if __name__ == '__main__':
    app.run(host='0.0.0.0',debug=True, port=5001)
