class TestController {
    def echo() {
        render 'here'
    }

    def index() { }

    def model() {
        [city: 'Philadelphia', team: 'Phillies']
    }
}