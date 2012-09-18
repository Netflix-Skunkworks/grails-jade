class TestController {
    def echo() {
        render 'here'
    }

    def index() { }

    def model() {
        [city: 'Philadelphia', team: 'Phillies']
    }

    def flash() {
        flash.message = 'This is a flash message'
    }

    def layout() {
        render view: 'layoutTest', model: [title: 'Layout Test']
    }

}