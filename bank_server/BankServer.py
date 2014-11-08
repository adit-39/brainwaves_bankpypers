from flask import Flask,json
import utils

app = Flask(__name__)

@app.route('/api/get_balance/<acc_num>')
def get_balance(acc_num):
	acc=int(acc_num)
	current=utils.fetch_curr_bal(acc)
	return json.dumps(current)

@app.route('/api/get_dues/<acc_num>')
def get_dues(acc_num):
	acc=int(acc_num)
	dues=utils.fetch_dues(acc)
	return json.dumps(dues)

if __name__ == '__main__':
    app.run(host='0.0.0.0',debug=True)
