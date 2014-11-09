from flask import Flask,json,render_template,url_for

app = Flask(__name__)


@app.route('/api/withdraw')
def map_ret():
	return render_template("h1.html")

@app.route('/api/loan')
def map_ret2():
	return render_template("h2.html")

if __name__ == '__main__':
    app.run(host='0.0.0.0',debug=True, port=5002)
